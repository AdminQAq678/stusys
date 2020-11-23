package com.wocnz.stusys.awt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wocnz.stusys.domain.Student;
import com.wocnz.stusys.domain.Teacher;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service

/**
 * 根据用户名和密码获取token
 * 获得token
 */
public class TokenService {
    public static  String getToken(Object user) {
        String no="";
        String passwd="";
        //判断是学生还是老师
        if(user instanceof Student){
            no=((Student) user).getSno();
            passwd=((Student) user).getPasswd();
        }else if (user instanceof Teacher){
            no=((Teacher) user).getTno();
            passwd=((Teacher) user).getPasswd();
        }

            Date start = new Date();
            long currentTime = System.currentTimeMillis() + 60*60*1000;//一小时有效时间
            Date end = new Date(currentTime);
            String token = "";
            token = JWT.create().withAudience(no).withIssuedAt(start).withExpiresAt(end)
                    .sign(Algorithm.HMAC256(passwd));
            System.out.println(token);
            return token;
    }
}

