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
