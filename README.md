# SpringInAction4
《Spring In Action 4th》学习笔记
---

## 第一部分 Spring的核心
### 1. Spring之旅
* 依赖注入
* AOP
* bean的初始化过程
* spring容器
* [demo](https://github.com/peijie-sh/SpringInAction4/tree/master/knight)

### 2. 装配Bean
* “initialization on demand holder”创建单例模式的理解,参考 [Initialization-on-demand holder idiom](https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom)
* Spring中单例的概念限于Spring上下文中，遵守约定
* 内部bean适用于setter注入和构造器注入，内部bean不能被复用
* SpEL表达式
* [管理Bean](https://github.com/peijie-sh/SpringInAction4/tree/master/Spring-bean)

### 3. 高级装配
* 4 种自动装配 byName, byType, contructor, autodetect
* 可以在一个应用上下文中定义多个配置文件，每个配置文件设置自己的默认自动装配策略(default-autowire)
* 如果使用constructor自动装配策略，就不能混合使用constructor-arg
* 注解方式可以实现更细粒度的自动装配，Spring容器默认禁用注解装配，要在配置文件中开启
* \<context:component-scan> 配置自动扫描
* 在基于Java的配置中使用@Configuration注解的Java类，等价于XML配置中的\<beans>元素
* [高级装配](https://github.com/peijie-sh/SpringInAction4/tree/master/Spring-bean-plus)

### 4. 面向切面的Spring
* Spring只支持方法连接点
* 体会切面的应用场景
* before, after, around advice
* 为advice传递参数
* introduction为已有的接口引入新接口
* at aspect [aspect-demo](https://github.com/peijie-sh/SpringInAction4/tree/master/Spring-aspectj)
* [AOP](https://github.com/peijie-sh/SpringInAction4/tree/master/Spring-aop)

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
留个官方demo，用到再看
* [Spring Web Flow](https://github.com/peijie-sh/SpringInAction4/tree/master/SpringPizza)

### 9. 保护Web应用
使用`Spring Security`安全框架，权限控制，登录认证，跨站请求保护，jsp标签，thymeleaf标签。
在Web层控制安全。
* [Spring Security入门](https://github.com/peijie-sh/SpringInAction4/tree/master/Spittr-security-basic)

## 第三部分 后端中的Spring
### 10. 通过Spring和JDBC征服数据库
封装jdbc样板代码（连接，关闭连接释放资源，错误处理），只关注业务逻辑。
* [Spring JDBC](https://github.com/peijie-sh/SpringInAction4/tree/master/Spring-jdbc)

### 11. 使用对象-关系映射持久化数据
* [集成Hibernate](https://github.com/peijie-sh/SpringInAction4/tree/master/hibernate4)
* `JPA`配置方式:
    * spring3.1开始，可在`LocalContainerEntityManagerFactoryBean`设置`packagesToScan`属性，所以不再需要`persistence.xml`文件了。
    * [集成JPA](https://github.com/peijie-sh/SpringInAction4/tree/master/jpa-hibernate)
* `Spring Data`配置方式:
    * xml方式: `<jpa:repositories>`
    * java config: `@EnableJpaRepositories`
    * [使用Spring Data](https://github.com/peijie-sh/SpringInAction4/tree/master/jpa-springdata)

### 12. 使用NoSQL数据库
* `MongoDB` 文档关系数据库，保存类似json对象。
    * 构建`MongoClient`和`MongoRepository`;
    * 使用`@Document`标记文档对象;
    * [使用Spring Data MongoDB](https://github.com/peijie-sh/SpringInAction4/tree/master/mongo)
* `Neo4j` 图数据库,暂时没研究，丢个demo先。
    * [使用Spring Data Neo4j](https://github.com/peijie-sh/SpringInAction4/tree/master/neo4j)
* `Redis` 高性能Key-Value数据库，可用作缓存数据库。
    * 4种连接工厂:`JedisConnectionFactory`,`JredisConnectionFactory`,`LettuceConnectionFactory`,`SrpConnectionFactory`;
    * 2种数据模板:
        * `RedisTemplate`支持所有数据类型;
        * `StringRedisTemplate`扩展了`RedisTemplate`，只关注`String`类型;
    * 多种序列化器: [比如，将key序列化为String，将value序列化为json]
        * `GenericToStringSerializer`:使用Spring转换服务进行序列化;
        * `JacksonJsonRedisSerializer`:使用Jackson 1，将对象序列化为JSON;
        * `Jackson2JsonRedisSerializer`:使用Jackson 2，将对象序列化为JSON;
        * `JdkSerializationRedisSerializer`:使用Java序列化;
        * `OxmSerializer`:使用Spring O/X映射的编排器和解排器（marshaler和unmarshaler）实现
    序列化，用于XML序列化;
        * `StringRedisSerializer`:序列化String类型的key和value;
    * [使用Spring Data Redis](https://github.com/peijie-sh/SpringInAction4/tree/master/redis)
    
### 13. 缓存数据
* java config方式:`@EnableCaching`
* xml方式:使用Spring cache命名空间中的`<cache:annotation-driven>`元素来启用注解驱动的缓存。
* 开启之后需要声明一个`CacheManager`，实现缓存。
* Spring 3.1内置了5个实现:
    * `SimpleCacheManager`
    * `NoOpCacheManager`
    * `ConcurrentMapCacheManager`
    * `CompositeCacheManager`
    * `EhCacheCacheManager`
* Spring Data提供2个实现:
    * `RedisCacheManager`（来自于Spring Data Redis项目）
    * `GemfireCacheManager`（来自于Spring Data GemFire项目）
* `CompositeCacheManager`多缓存支持，可以同时使用多种缓存。
* 开启spring cache 注解驱动的缓存后，就可以在方法上使用`@Cacheable`和`@CacheEvict`来控制加入缓存和去除缓存了。
* 此外，也可以在xml中配置，在具体方法上使用缓存，不过不推荐。
* [使用Spring Cache](https://github.com/peijie-sh/SpringInAction4/tree/master/caching)

### 14. 保护方法应用
方法级别安全保护。一般在Web层之后，比如service层。
Spring Security提供了三种不同的安全注解:
* Spring Security自带的@Secured注解: 配置类添加`@EnableGlobalMethodSecurity(securedEnabled=true)`，然后可在方法上使用，限制用户须拥有权限才可执行方法。
* JSR-250的@RolesAllowed注解: 配置类添加`@EnableGlobalMethodSecurity(jsr250Enabled=true)`，然后可在方法上使用，限制用户须拥有权限才可执行方法。
* 表达式驱动的注解(Spring Security 3.0)
    * `@PreAuthorize` 在方法调用之前，基于表达式的计算结果来限制对方法的访问
    * `@PostAuthorize` 允许方法调用，但是如果表达式计算结果为false，将抛出一个安全性异常
    * `@PostFilter` 允许方法调用，但必须按照表达式来过滤方法的结果
    * `@PreFilter` 允许方法调用，但必须在进入方法之前过滤输入值
* [Spring Security Methods](https://github.com/peijie-sh/SpringInAction4/tree/master/Sprittr-security-method)

## 第四部分 Spring集成
### 15. 使用远程服务
### 16. 使用Spring MVC创建REST API
* 使用`@RequestBody`,`@ResponseBody`,`@RestController`。
* `ResponseEntity`包含`@ResponseBody`的作用，默认使用消息转换，可添加响应状态和元数据。
* 使用`@ResponseStatus`指定响应状态。

### 17. Spring消息
留个官方demo，用到再看
* [JMS](https://github.com/peijie-sh/SpringInAction4/tree/master/jms)
* [AMQP](https://github.com/peijie-sh/SpringInAction4/tree/master/amqp)

### 18. 使用WebSocket和STOMP实现消息功能
留个官方demo，用到再看
* [STOMP](https://github.com/peijie-sh/SpringInAction4/tree/master/STOMP)
* [STOMPUser](https://github.com/peijie-sh/SpringInAction4/tree/master/STOMPUser)
* [WebSocket](https://github.com/peijie-sh/SpringInAction4/tree/master/WebSocket)

### 19. 使用Spring发送Email
这个比较简单，构造一个bean，注入Spring容器，然后调用api发邮件即可。
* 简单邮件
* 带附件的邮件
* 用模板构造邮件
* [Spring Mail](https://github.com/peijie-sh/SpringInAction4/tree/master/Spring-mail)

### 20. 使用JMX管理Spring Bean
### 21. 借助Spring Boot简化Spring开发
* 减少配置，快速构建服务。
* [Spring Boot](https://github.com/peijie-sh/SpringInAction4/tree/master/springboot)