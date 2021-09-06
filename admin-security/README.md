# 工程简介
使用spring boot security认证并且对所有后端接口鉴权
主要功能包括，颁发token，通过用户名密码登陆+验证码登陆/微信登陆/支付宝登陆,由于Spring security是通过过滤器实现用户认证的，我们可以模仿UsernamePasswordAuthenticationFilter来实现自己的权限认证
 鉴别权限，判断当前用户是否有权限访问指定url

# spring security 源码解析
## 默认过滤器
 只需引入spring-boot-starter-security即可搭建默认spring  security，通过日志可以看出默认Spring security是由如下一系列过滤器组成：
   1.WebAsyncManagerIntegrationFilter 
   2.SecurityContextPersistenceFilter  
      获取 securityContext对象并且将他们放入SecurityContextHolder(三种存储策略)中，同时将requestResponseHolder
   3.HeaderWriterFilter  
   4.CsrfFilter 继承自OncePerRequestFilter 首先获取CsrfToken如果不存在则创建一个，并将其放入request属性中，
     默认GET, HEAD, TRACE, OPTIONS不会做csrf校验，校验逻辑是首先取header中的X-XSRF-TOKEN值，如果获取不到则从参数中获取，
     然后将这个值和CsrfToken中的token比对如果值相同则交给下个过滤器，如果值不同则交给AccessDeniedHandlerImpl处理
     CsrfToken有三种类型，cookie session Lazy三种方式的
   5.LogoutFilter 继承自GenericFilterBean 该类比较简单 匹配所配置的logout路径，然后做logout操作，退出登陆后跳转到targeturl或者useReferer
其中RequestMatcher(默认匹配/logout) LogoutHandler ;LogoutSuccessHandler 都可以自定义
   6.UsernamePasswordAuthenticationFilter
   7.DefaultLoginPageGeneratingFilter
  
  OncePerRequestFilter 顾名思义，每次请求只调用一次过滤器，判断逻辑，如果当前过滤器是异步过滤器并且支持异步或者已经调用过的过滤器则调用下一个过滤器
    否则调用doFilterInternal方法，对于过滤器已经执行过切请求类型为异常请求的则调用doFilterNestedErrorDispatch
  GenericFilterBean
  (1) Filter，实现过滤器；
  (2) BeanNameAware，实现该接口的setBeanName方法，便于Bean管理器生成Bean；
  (3) EnvironmentAware，实现该接口的setEnvironment方法，指明该Bean运行的环境；
  (4) ServletContextAware，实现该接口的setServletContextAware方法，指明上下文；
  (5) InitializingBean，实现该接口的afterPropertiesSet方法，指明设置属性生的操作；
  (6) DisposableBean，实现该接口的destroy方法，用于回收资源
##spring security核心组件与作用
  1. Userdetails 
  2. Authentication: 用于定义当前用户是谁，包含用户信息(Details)，用户角色信息(Authorities)
  3. UserDetailsService4
  4. AuthenticationProvider
  5. AuthenticationManager 
  

# 延伸阅读

