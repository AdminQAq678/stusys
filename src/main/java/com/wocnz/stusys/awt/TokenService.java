package com.wocnz.stusys.awt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wocnz.stusys.domain.Student;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service

/**
 * 获得token
 */
public class TokenService {
    public String getToken(Student student) {
        student.setSno("111");
        student.setSname("黄一度");
            Date start = new Date();
            long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
            Date end = new Date(currentTime);
            String token = "";
            token = JWT.create().withAudience(student.getSno()).withIssuedAt(start).withExpiresAt(end)
                    .sign(Algorithm.HMAC256(student.getSname()));
            System.out.println(token);
            return token;
    }
}

