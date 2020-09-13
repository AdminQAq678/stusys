package com.wocnz.stusys.controller;

import com.alibaba.excel.EasyExcel;
import com.wocnz.stusys.awt.UserLoginToken;
import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Student;
import com.wocnz.stusys.service.Impl.StudentSerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@RestController
public class studentCon {
    /**
     * 获取所有学生信息
     * @param sno
     * @return
     */

    ArrayList<Student> result=new ArrayList<>();

    @Autowired
    StudentSerImpl stuSerImpl;

    @RequestMapping("/findAllStu")
    public List<Student> findAllStu(){


        return stuSerImpl.findAllStu();
    }

    /**
     * 根据学号查询学生信息
     * @param sno
     * @return student
     */
    @RequestMapping(value = "/student/{sno}",method = RequestMethod.GET)
    public Student findStudentById(@PathVariable("sno") String sno){
        System.out.println(sno);
        System.out.println("get");
        return stuSerImpl.findStudentBySno(sno);
    }

    /**
     * 根据学号更新学生信息
     * @param sno 要修改学生的学号
     * @param stu 该学生的新信息
     * @return
     */
    @RequestMapping(value = "/student/{sno}",method = RequestMethod.PUT)
    public Student updateStudent(@PathVariable("sno") String sno,@RequestBody Student stu){
        System.out.println(sno);
        System.out.println(stu);
        System.out.println("update");
        return  stuSerImpl.updateStudent(sno,stu);
    }
    /**
     * 新增学生生信息
     *
     * @param stu
     * @return
     */
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public boolean addStudent(@RequestBody Student stu){
        System.out.println("add");

        if(stu.getSdept().length()==0){
            stu.setSdept(null);
        }
        return  stuSerImpl.addStudent(stu);
    }
    /**
     * 根据sno查询学生信息
     *
     * @param sno
     * @return null
     */
    @RequestMapping(value = "/student/{sno}",method = RequestMethod.DELETE)
    public boolean  delStudent(@PathVariable("sno") String  sno){

        return stuSerImpl.delStudent(sno);

    }

    @RequestMapping(value = "/findStudentByCon",method = RequestMethod.GET)
    public Condition  findStudentByCon( Condition con){
        Condition condition=stuSerImpl.findAllStuByCon(con);
        result= (ArrayList<Student>) condition.getData();
        return condition;

    }

    @RequestMapping(value = "/addStuByFile" , method = RequestMethod.POST)
    public String upload( MultipartFile file) throws IOException {
        FileInputStream inputStream= (FileInputStream) file.getInputStream();
        String s=new String(file.getBytes());
//        System.out.println(s);

        Scanner scanner=new Scanner(inputStream);



        while (scanner.hasNext()){
            //获取一行记录
            String s1 = scanner.nextLine();
            //,号分割
            String[] t = s1.split(",");
            Student student=new Student();
            student.setSno(t[0]);
            student.setSname(t[1]);
            student.setSage(Integer.parseInt(t[2]));
            student.setSsex(t[3]);
            student.setSdept(t[4]);
            stuSerImpl.addStudent(student);
        }

        return "";
    }






    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        String fileName = URLEncoder.encode("学生信息", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Student.class).sheet("模板").doWrite(data());
    }

    private List<Student> data() {
        Logger logger= LoggerFactory.getLogger("stucon");
        logger.info(result.toString());
        List<Student> list = result;
//        System.out.println("result+++++"+result);
//        for (int i = 0; i < result.size(); i++) {
//            Student data = new Student();
//
//            data.setSdept("asdd");
//            data.setSno(result.get(i).getSno());
//            data.setSname(result.get(i).getSname());
//            data.setSsex(result.get(i).getSsex());
//            data.setSage(result.get(i).getSage());
//            data.setSdept(result.get(i).getSdept());
//            list.add(data);
//        }
        return list;
    }


}
