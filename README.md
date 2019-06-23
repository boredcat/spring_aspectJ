基于AspectJ的AOP开发笔记
---

## @AspcetJ 提供不同的通知类型

* @Before 前置通知，相当于BeforeAdvice
* @AfterReturning 后置通知 相当于AfterReturningAdvice
* @Around环绕通知 相当于MethodInterceptor（可以阻止目标方法执行）
* @AfterTrowing 异常抛出通知 相当于ThrowAdvice
* @After 最终final通知 不管是否有异常，该通知都会执行
* @DeclareParents 引介通知 相当于IntroductionInterceptor

## 切入点表达式定义

在通知中通过value属性定义切点
 
* 通过execution函数 可以定义切点的方法切入

* 语法：

    - execution(<访问修饰符>?<返回类型><方法名>(<参数>)<异常>)

例如

- 匹配所有的类public方法 execution(public * *(..))
- 匹配指定包下的所有类方法 execution(* com.evan.dao.*(..)) ``不包含子包``
- execution(* com.evan.dao..*(..))  ..*表示包、子孙包下所有类
- 匹配指定类的所有方法 execution(* com.evan.service.UserService.*(..))
- 匹配实现特定接口所有类方法execution(* com.evan.dao.GenericDAO+.*(..))
- 匹配所有save开头的方法execution(\*save\*(..))

### @Around环绕通知

* around方法的返回值就是目标代理方法执行返回值
* 参数为ProceedingJoinPoint可以调用拦截目标方法执行
``如果不调用ProcessdingJoinPoint的proceed方法，那么目标方法就被拦截类``

### @AfterThrowing异常抛出通知

* 通过设置throwing属性，可以设置发送异常对象参数
* 配合环绕通知做事务操作

### @After最终通知

* 相当于finally

### 通过@Pointcut为切点命名

* 对于重复的切点可以使用@Ponitcut进行定义
* 切点方法：private void 无参数方法，方法名为切点名
* 当通知多个切点时，可以使用||进行连接