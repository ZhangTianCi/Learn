####### Spring boot 项目目录结构
> https://blog.csdn.net/yunyishang123/article/details/80632644
>#####根目录：src.main.java
>1. 工程启动类(Application.java)：置于com.cy.project包下或者com.cy.project.app包下  
>2. 实体类(domain)：置于com.cy.project.domain
>3. 数据访问层(Dao)：置于com.cy.project.repository（dao）
>4. 数据服务层(Service)：置于com.cy.project.service
>5. 数据服务接口的实现(serviceImpl)：同样置于com.cy.project.service或者置于com.cy.project.service.impl  
>6. 前端控制器(Controller)：置于com.cy.project.controller
>7. 工具类(utils)：置于com.cy.project.utils
>8. 常量接口类(constant)：置于com.cy.project.constant  
>9. 配置信息类(config)：置于com.cy.project.config
>#####资源文件：src.main.resources
>1. 页面以及js/css/image等置于static文件夹下的各自文件下  
>2. 使用模版相关页面等置于templates文件夹下的各自文件下