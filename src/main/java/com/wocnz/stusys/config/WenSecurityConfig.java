//package com.wocnz.stusys.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//public class WenSecurityConfig extends WebSecurityConfigurerAdapter {
////
////    @Bean
////    PasswordEncoder passwordEncoder(){
////        return new BCryptPasswordEncoder();
////    }
////
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .antMatchers("/tea/**")
////                .access("hasAnyRole('TEA','ADMIN')")
////                .anyRequest()
////                .authenticated()
////                .and()
////                .formLogin()
////                .loginProcessingUrl("/login")
////                .permitAll()
////                .and()
////                .csrf()
////                .disable();
////    }
//}
