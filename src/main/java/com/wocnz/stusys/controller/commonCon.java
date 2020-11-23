package com.wocnz.stusys.controller;

import com.wocnz.stusys.domain.Student;
import com.wocnz.stusys.service.Impl.commonSerImpl;
import com.wocnz.stusys.service.StudentSer;
import com.wocnz.stusys.service.TeacherSer;
import com.wocnz.stusys.service.commonSer;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;


@RestController
public class commonCon {
    @Autowired
    commonSerImpl common;


    @PostMapping("/stu/chgpasswd")
    public boolean chgPasswd(String uid,String prePasswd, String newPasswd){
        return  common.chgpasswd(uid, prePasswd, newPasswd);

    }

    @GetMapping("/getUserInfo")
    public Object getUserInfo(String uid){
        System.out.println("用户id"+uid);
        System.out.println(common.getUserInfo(uid).toString());
        return  common.getUserInfo(uid);
    }


    @PostMapping("/uploadImage")
    public  String  uploadImage(HttpServletRequest httpServletRequest, MultipartFile file)  {
        File f=null;
        FileOutputStream fos=null;
        FileInputStream fis=null;
        String imgUrl=null;
        String uid=null;
        byte b[]=new byte[1024];
        int bb=0;

        if(file.getContentType().indexOf("jpeg")!=-1){
            imgUrl="head"+System.currentTimeMillis()+".jpg";
            f=new File(imgUrl);
        }else{
            imgUrl="head"+System.currentTimeMillis()+".png";
            f=new File(imgUrl);

        }
        //如果文件不存在则创建文件
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fos=new FileOutputStream(f);
            fis= (FileInputStream) file.getInputStream();
            //写文件
            while((bb=fis.read(b))!=-1){
                fos.write(b,0,b.length);
            }
            //保存文件路径到数据库



        } catch (IOException e) {
            e.printStackTrace();
        }


        return f.getAbsolutePath();
    }

    @RequestMapping(value="/saveImageUrl",method = RequestMethod.POST)
    public  boolean  saveImgeUrl(@RequestBody Map<String,String> imageUrl){

        System.out.println(imageUrl);
        return common.uploadImage(imageUrl.get("uid"),imageUrl.get("imageUrl"));
    }


    @RequestMapping(value="/getHeadImage")
    public  void  getHeadImage(HttpServletResponse response, String uid){
        System.out.println("uid"+uid);
        File file=common.getHeadImage(uid);
        byte b[]=new byte[1024];
        int bb=0;
        try {
            FileInputStream fis=new FileInputStream(file);
            while((bb=fis.read(b))!=-1){
                response.getOutputStream().write(b,0,b.length);
            }
        } catch (FileNotFoundException e) {
            System.out.println("无该用户头像");
            //e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ;
    }

}
