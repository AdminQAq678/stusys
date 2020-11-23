package com.wocnz.stusys.controller;

import com.wocnz.stusys.domain.Student;
import com.wocnz.stusys.service.Impl.commonSerImpl;
import com.wocnz.stusys.service.StudentSer;
import com.wocnz.stusys.service.TeacherSer;
import com.wocnz.stusys.service.commonSer;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
