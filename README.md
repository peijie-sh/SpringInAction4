# SpringInAction4
《Spring In Action 4th》学习笔记
---

## 第一部分 Spring的核心
### 1. Spring之旅

### 2. 装配Bean

### 3. 高级装配

### 4. 面向切面的Spring

## 第二部分 Web中的Spring
### 5. 构建Spring Web应用程序
* [最简单的Spring MVC](https://github.com/peijie-sh/SpringInAction4/tree/master/Spittr-basic)
* [路径参数 & 表单提交](https://github.com/peijie-sh/SpringInAction4/tree/master/Spittr)

### 6. 渲染Web视图
主要是视图模板技术，比如`freemarker`，`velocity`，`thymeleaf`等，放2个官方源码参考吧。
* [JSP视图](https://github.com/peijie-sh/SpringInAction4/tree/master/Spittr-jsp)
* [Thymeleaf视图](https://github.com/peijie-sh/SpringInAction4/tree/master/Spittr-thymeleaf)

### 7. Spring MVC的高级技术
* servlet3.0之前的搭建方式：使用`web.xml`配置声明
* multipart上传数据：`MultipartFile`类型，`@RequestPart`注解
* 统一异常处理：`@ExceptionHandler`（方法级别，处理具体某种exception），`@ControllerAdvice`（类级别，集中处理异常方法）
* 重定向带参数：RedirectAttributes.addFlashAttribute()

### 8. 使用Spring Web Flow
暂时没用到，放个官方源码，以后在研究。
* [Spring Web Flow](https://github.com/peijie-sh/SpringInAction4/tree/master/SpringPizza)

### 9. 保护Web应用
使用`Spring Security`安全框架，权限控制，登录认证，跨站请求保护，jsp标签，thymeleaf标签。
* [Spring Security入门](https://github.com/peijie-sh/SpringInAction4/tree/master/Spittr-security-basic)

## 第三部分 后端中的Spring
### 10. 通过Spring和JDBC征服数据库
封装jdbc样板代码（连接，关闭连接释放资源，错误处理），只关注业务逻辑。
* [Spring JDBC](https://github.com/peijie-sh/SpringInAction4/tree/master/Spring-jdbc)

### 11. 使用对象-关系映射持久化数据
* [集成Hibernate](https://github.com/peijie-sh/SpringInAction4/tree/master/hibernate4)
* `JPA`配置方式:
    * spring3.1开始，可在`LocalContainerEntityManagerFactoryBean`设置`packagesToScan`属性，所以不再需要，`persistence.xml`文件了。
    * [集成JPA](https://github.com/peijie-sh/SpringInAction4/tree/master/jpa-hibernate)
* `Spring Data`配置方式:
    * xml方式: `<jpa:repositories>`
    * java config: `@EnableJpaRepositories`
    * [使用Spring Data](https://github.com/peijie-sh/SpringInAction4/tree/master/jpa-springdata)


### 12. 使用NoSQL数据库
### 13. 缓存数据
### 14. 保护方法应用
## 第四部分 Spring集成
### 15. 使用远程服务
### 16. 使用Spring MVC创建REST API
### 17. Spring消息
### 18. 使用WebSocket和STOMP实现消息功能
### 19. 使用Spring发送Email
### 20. 使用JMX管理Spring Bean
### 21. 借助Spring Boot简化Spring开发
