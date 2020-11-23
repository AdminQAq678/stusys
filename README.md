## 项目： 学生选课系统

### 项目构建和部署方法
1. git clone https://github.com/AdminQAq678/stusys.git 或者直接download后解压
2. 用idea或者eclipse打开 用maven进行clean 和 package
3. 如果src/main/resource  目录不是Resource Root目录 项目运行会报错 需要将 src/main/ressource 目录设置为
Resource Root， Idea 的设置方式为 右键resource目录-> make directory as ->Resource Root
4. 项目默认访问端口为 8080端口
5. 数据库账号和密码以及链接的数据库需要在src/main/resources/application.properties 文件中进行设置


time：202/9/4 00：34

6. 在sql目录下有数据库结构文件 stusys.mwb 以及sql文件stusys.sql，需要运行在本地运行sql文件，服务器才能够访问数据库，
mysql 控制台运行方法为 : 先登录mysql 然后运行 source stusys.sql
workbench 复制sql语句运行。。。

2020/9/4 22:20

7. 前端html css js文件放置说明
前端文件需要放置在 src/main/webapp目录下才可以供浏览器访问


### 跨域问题解决
···java
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }
    }


### 后端获取不到前端数据的问题
在参数里面加@RequestBody注解 可以将参数对象解析出来

### 需要添加课程信息的显示和操作
✔添加教师主讲课程依赖于课程信息
✔添加学生依赖于系别

添加选课功能
✔添加导入信息功能

✔添加下载信息功能

添加登录功能
✔添加token鉴权功能

#2020/9/17

✔添加学生及教师注册接口，即student 和teacher的post接口

✔todo :
    添加登录注册接口

##增加教师个人教授课程
✔通过输入（选择）教师名称，以及课程实现增加

###教师所授课程的显示
✔通过便利连接teascourse 和course和teacher表进行显示

#学生选课逻辑
✔根据显示的课程列表进行选课，一门课只能选择一次，需要将学生学号及课程号共同作为主键
在sct表中添加学生学生学号、cno和tno通过表teascourses来插入

✔需要解决登录后使用学生学号选课的问题（前端页面)，目前选课功能只是使用了固定的学生学号进行选课
### 各个模块的搜索功能
✔学生模块的搜索功能
### 权限管理功能
✔简单的权限管理
### 图片上传功能
✔已实现
> 2020/11/23
### 项目目录结构说明
* java 
    * com.wocnz.stusys
        * awt 鉴权登录相关类
        * controller 接口类
        * dao 放置数据库操作接口和它们的实现类
            * impl 放置dao接口的实现类
        * domain 各种javabean
        * service 服务，用于调用Dao
        * utils 阿里云人脸识别相关类，用不到，可忽略
        * websocket 可忽略
        * StusysApplication 项目的启动类
        * WebMvcConfig 解决跨域请求问题，允许前端在尚未部署项目到后端时也可访问后端的接口
* resources 资源文件放置
    application.properties 用于项目配置的相关文件
* sql sql文件放置目录
   stusys.mwb 数据库结构设计文件，用于设计数据库结构
   stusys.sql 由stusys.mwb 导出的sql文件
* webapp 前端项目部署文件放置的目录

### 项目逻辑说明
* xxxdao 
    * 是用户数据库的接口类，xxxDaoImpl是xxxdao的实现类，向上层service提供“服务”
* xxxservice 
    * 服务，为controller提供相应的功能，xxxserviceImpl是其具体实现，向上传controller提供“服务”
* xxxcontroller 
    * 是前端访问的接口，一个接口类中的每一个方法都可以是一个接口，通过调用service/impl/xxxserviceImpl中的方法，实现接口的功能



    

