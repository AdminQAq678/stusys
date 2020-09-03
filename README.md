### 项目构建和部署方法
1. git clone https://github.com/AdminQAq678/stusys.git 或者直接download后解压
2. 用idea或者eclipse打开 用maven进行clean 和 package
3. 如果src/main/resource  目录不是Resource Root目录 项目运行会报错 需要将 src/main/ressource 目录设置为
Resource Root， Idea 的设置方式为 右键resource目录-> make directory as ->Resource Root
4. 项目默认访问端口为 8080端口
5. 数据库账号和密码以及链接的数据库需要在src/main/resources/application.properties 文件中进行设置
