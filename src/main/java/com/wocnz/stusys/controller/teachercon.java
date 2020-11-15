package com.wocnz.stusys.controller;


import com.alibaba.excel.EasyExcel;
import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Student;
import com.wocnz.stusys.domain.Teacher;
import com.wocnz.stusys.service.Impl.TeacherSerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 教师信息的增删查改
 */
@RestController
public class teachercon {
    @Autowired
    TeacherSerImpl teaSerImpl;

    ArrayList<Teacher> result=new ArrayList<>();
    /**
     * 获取所有老师
     * @param tno
     * @return
     */
    @RequestMapping("/findAllTea")
    public List<Teacher> findAll(@PathParam("tno") String tno){
        return  teaSerImpl.findAllTea();

    }

    /**
     * 根据教师编号号查询老师信息
     * @param tno
     * @return
     */
    @RequestMapping(value = "/teacher/{tno}",method = RequestMethod.GET)
    public Teacher findStudentById(@PathVariable("tno") String tno){

        return teaSerImpl.findTeacherBytno(tno);
    }

    /**
     * 根据学号更新老师信息
     * @param tno 要修改学生的学号
     * @param tea 该学生的新信息
     * @return
     */
    @RequestMapping(value = "/teacher/{tno}",method = RequestMethod.PUT)
    public Teacher updateStudent(@PathVariable("tno") String tno,@RequestBody Teacher tea){

        return teaSerImpl.updateTeacher(tno,tea);
    }
    /**
     * 新增老师信息
     *
     * @param tea
     * @return
     */
    @RequestMapping(value = "/teacher",method = RequestMethod.POST)
    public boolean addStudent( @RequestBody Teacher tea){

        return teaSerImpl.addTeacher(tea);
    }
    /**
     * 根据tno查询老师信息
     *
     * @param tno
     * @return
     */
    @RequestMapping(value = "/teacher/{tno}",method = RequestMethod.DELETE)
    public boolean delStudent(@PathVariable("tno") String tno){
        return teaSerImpl.delTeacher(tno);
    }

    @RequestMapping(value = "/findTeacherByCon",method = RequestMethod.GET)
    public Condition findStudentByCon(Condition con){
        Condition condition=teaSerImpl.findAllTeaByCon(con);
        result= (ArrayList<Teacher>) condition.getData();
        return condition;

    }

    /**
     * 上传txt文件添加学生信息
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/addTeaByFile" , method = RequestMethod.POST)
    public String upload( MultipartFile file) throws IOException {
        //file是前端上传的文件，
        FileInputStream inputStream= (FileInputStream) file.getInputStream();
        String s=new String(file.getBytes());
        Scanner scanner=new Scanner(inputStream);
        //读取每一行记录
        while (scanner.hasNext()){
            //获取一行记录
            String s1 = scanner.nextLine();
            //,号分割
            String[] t = s1.split(",");
            Teacher teacher=new Teacher();
            teacher.setTno(t[0]);
            teacher.setTname(t[1]);
            teacher.setTsex(t[2]);
            teacher.setTage(Integer.parseInt(t[3]));
            teacher.setTeb(t[4]);
            teacher.setTpt(t[5]);
            teaSerImpl.addTeacher(teacher);
        }
        return "";
    }

    /**
     * 下载学生信息接口
     * @param response
     * @throws IOException
     */
    @GetMapping("downloadTea")
    public void download(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        String fileName = URLEncoder.encode("教师信息", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Teacher.class).sheet("信息").doWrite(data());
    }

    /**
     * 获取学生的信息列表供download 接口写到前端
     * @return
     */
    private List<Teacher> data() {

        Logger logger= LoggerFactory.getLogger("teaCon");//获得日志，作用类似system.out.priontln()
        logger.info(result.toString());
        List<Teacher> list = result;
        return list;
    }



}
