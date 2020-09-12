package com.wocnz.stusys.utils;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.baidu.aip.util.Base64Util;
import net.coobird.thumbnailator.Thumbnails;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 百度人脸对比接口
 *
 */
@Component
public class AiFunc {
    public static final String APP_ID = "22616327";
    public static final String API_KEY = "0bho7ptkcUNLaW4wdWDnhmIC";
    public static final String SECRET_KEY = "pSKzWDoeHGB2RbnGlsHmCpS9XPgZjwVO";

    private AipFace client;
    public AiFunc(){
        this.client = new AipFace(APP_ID,API_KEY,SECRET_KEY);
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
    }

    //将图片文件转base64字符串
    private String getImgStr(MultipartFile file) throws IOException {

        InputStream fileInputStream=  file.getInputStream();
        byte buffer []=new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        String imgstr= Base64Util.encode(buffer);
        return imgstr;
    }

    /**
     * 人脸比对
     * @param file
     * @param userid
     * @param groupid
     * @param options
     * @return 返回jsonObject对象
     * @throws IOException
     */
    public JSONObject diffFace(MultipartFile file,String userid,String groupid,HashMap<String,String> options) throws IOException {
        //人脸比对
        //从人脸数据库中获取face_token


        //
        String face_token= this.getFaceToken(userid,groupid,options);;
        String image1 = face_token;
        //上传文件
        String image2 = this.getImgStr(file);

        // image1/image2也可以为url或facetoken, 相应的imageType参数需要与之对应。
        MatchRequest req1 = new MatchRequest(image1, "FACE_TOKEN");
        MatchRequest req2 = new MatchRequest(image2, "BASE64");

        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);

        JSONObject res = client.match(requests);

        System.out.println(res.toString(2));

        return res.getJSONObject("result");

    }

    public JSONObject diffFace(String imgUrl,String userid,String groupid,HashMap<String,String> options){
        String face_token= this.getFaceToken(userid,groupid,options);;
        String image1 = face_token;
        //上传文件
        String image2 = imgUrl;

        // image1/image2也可以为url或facetoken, 相应的imageType参数需要与之对应。
        MatchRequest req1 = new MatchRequest(image1, "FACE_TOKEN");
        MatchRequest req2 = new MatchRequest(image2, "BASE64");

        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);

        JSONObject res = client.match(requests);

        System.out.println(res.toString(2));

        return res.getJSONObject("result");
    }

    /**
     * 从人脸数据库中获取face_token，跟上传的图片进行比对
     * @param userid
     * @param groupid
     * @param options
     * @return
     */
    private String getFaceToken(String userid,String groupid, HashMap<String,String> options){
        JSONObject jsonObject=client.faceGetlist(userid,groupid,options);
        System.out.println(jsonObject.getJSONObject("result").getJSONArray("face_list").getJSONObject(0).getString("face_token"));
        return jsonObject.getJSONObject("result").getJSONArray("face_list").getJSONObject(0).getString("face_token");
    }

    //添加用户组
    private JSONObject groudAdd(String newGroup,HashMap<String,String> options){

        return  client.groupAdd(newGroup, options);

    }




}
