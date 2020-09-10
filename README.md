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
添加教师主讲课程依赖于课程信息
添加学生依赖于系别

添加选课功能
添加导入信息功能

添加登录功能
添加token鉴权功能



