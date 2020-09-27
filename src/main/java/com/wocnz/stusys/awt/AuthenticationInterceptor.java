package com.wocnz.stusys.awt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.wocnz.stusys.domain.Student;
import com.wocnz.stusys.domain.Teacher;
import com.wocnz.stusys.service.Impl.StudentSerImpl;
import com.wocnz.stusys.service.Impl.TeacherSerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拦截器
 * @author qiaoyn
 * @date 2019/06/14
 */

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    StudentSerImpl studentSer;

    @Autowired
    TeacherSerImpl teacherSer;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    System.out.println("无token，请重新登录");

//                    throw new RuntimeException("");
                return false;

                }
                // 获取 token 中的 user id
                String userId;
                try {
                    userId = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {

                    throw new RuntimeException("401");
                }


                Student user=null;

                Teacher tea=null;

                // 验证 token
                JWTVerifier jwtVerifier;
                //教师登录
                if(userId.substring(0,2).equals("66")){
                    tea=teacherSer.findTeacherBytno(userId);
                    jwtVerifier= JWT.require(Algorithm.HMAC256(tea.getPasswd())).build();
                }else
                {
                    user = studentSer.findStudentBySno(userId);
                    jwtVerifier= JWT.require(Algorithm.HMAC256(user.getPasswd())).build();
                }

                if (user ==  null && tea==null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }


                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    //token 过期或者token错误
                    throw new RuntimeException("token错误");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}