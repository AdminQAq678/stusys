package com.wocnz.stusys.controller;


import com.alibaba.excel.EasyExcel;
import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Course;
import com.wocnz.stusys.domain.Teacher;
import com.wocnz.stusys.service.Impl.CourseSerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 课程信息的增删查改
 */
@RestController
public class CourseCon {
    /**
     * 获取所有课程信息
     * @param sno
     * @return
     */
    ArrayList<Course> result=new ArrayList<>();

    @Autowired
    CourseSerImpl courseSerImpl;

    @RequestMapping("/findAllCou")
    public List<Course> findAllCou(){
        return courseSerImpl.findAllCou();
    }

    /**
     * 根据课程号查询课程信息
     * @param cno
     * @return Course
     */
    @RequestMapping(value = "/course/{cno}",method = RequestMethod.GET)
    public Course findCourseById(@PathVariable("cno") String cno){
        System.out.println(cno);
        System.out.println("get");
        return courseSerImpl.findCourseByCno(cno);
    }

    /**
     * 根据学号更新学生信息
     * @param cno 要修改课程的课程号
     * @param cou 该课程的新信息
     * @return
     */
    @RequestMapping(value = "/course/{cno}",method = RequestMethod.PUT)
    public Course updateCourse(@PathVariable("cno") String cno,@RequestBody Course cou){
        System.out.println(cno);
        System.out.println(cou);
        System.out.println("update");


        return  courseSerImpl.updateCourse(cno,cou);
    }
    /**
     * 新增学生生信息
     *
     * @param cou
     * @return
     */
    @RequestMapping(value = "/course",method = RequestMethod.POST)
    public ArrayList<Course> addCourse(@RequestBody Course cou){
        System.out.println("add");
        courseSerImpl.addCourse(cou);
        return null;
    }
    /**
     * 根据cno查询课程信息
     *
     * @param cno
     * @return null
     */
    @RequestMapping(value = "/course/{cno}",method = RequestMethod.DELETE)
    public boolean delCourse(@PathVariable("cno") String  cno){


        return  courseSerImpl.delCourse(cno);
    }

    @RequestMapping(value = "/findCourseByCon",method = RequestMethod.GET)
    public Condition findStudentByCon(Condition con){
        Condition condition=courseSerImpl.findAllCouByCon(con);
        result= (ArrayList<Course>) condition.getData();
        return condition;

    }

    /**
     * 上传txt文件添加学生信息
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/addCouByFile" , method = RequestMethod.POST)
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
            Course course=new Course();
            course.setCno(t[0]);
            course.setCname(t[1]);
            course.setCpno(t[2]);
            course.setCcredit(t[3]);
            courseSerImpl.addCourse(course);
        }
        return "";
    }

    /**
     * 下载学生信息接口
     * @param response
     * @throws IOException
     */
    @GetMapping("downloadCou")
    public void download(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        String fileName = URLEncoder.encode("课程信息", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Course.class).sheet("信息").doWrite(data());
    }

    /**
     * 获取学生的信息列表供download 接口写到前端
     * @return
     */
    private List<Course> data() {

        Logger logger= LoggerFactory.getLogger("CourseCon");//获得日志，作用类似system.out.priontln()
        logger.info(result.toString());
        List<Course> list = result;
        return list;
    }


}
