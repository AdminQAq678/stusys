package com.wocnz.stusys.dao.impl;

import com.wocnz.stusys.dao.CommonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class CommonDaoImpl implements CommonDao {
    @Autowired
    JdbcTemplate  jdbcTemplate;


    Logger logger= LoggerFactory.getLogger("CommonDao");

    @Override
    public boolean uploadImage(String uid, String imgurl) {
//        String sql="insert into images values(?,?) ";
        try {
            //先查询数据库是否有该用户的头像路径，没有会报错，则执行插入语句，将用户上传的图片路径插入到images表
            String sql1="select imageurl from images where id = ?";
            jdbcTemplate.queryForObject(sql1,String.class,uid);
        }catch (Exception e){
            String sql2="insert into images values (?,?)";
            int ret=jdbcTemplate.update(sql2,uid,imgurl);
            return ret>0?true:false;
        }
        //上面不报错则执行下面的语句
        //更新images表


        String sql="update images set imageurl=? where id=?";
        int cnt=jdbcTemplate.update(sql,imgurl,uid);
        if(cnt>0){
            logger.info("图片路径保存成功");
            return true;
        }
        logger.info("图片路径保存失败");
        return false;
    }

    @Override
    public File getHeadImage(String uid) {
        System.out.println(uid);
        String sql="select imageurl from images where id = ? ";
        //注意queryForObject的参数，应该先传入sql语句、返回类型，再传入参数
        String res="";
        try {
            res=(String) jdbcTemplate.queryForObject(sql,String.class,uid);
            System.out.println("文件路径"+res);
        }catch (EmptyResultDataAccessException e){
            System.out.println("无用户头像");

        }


        return new File(res);
    }
}
