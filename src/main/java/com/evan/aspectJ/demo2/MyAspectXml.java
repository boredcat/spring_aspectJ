package com.evan.aspectJ.demo2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspectXml {

    // 前置通知
    public void before(JoinPoint joinPoint){
        System.out.println("XML方法的前置通知=========="+joinPoint);
    }

    // 后置通知
    public void affterReturing(Object result){
        System.out.println("XML方式的后置通知=========="+result);
    }

    // 环绕通知
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知==================");
        Object object = joinPoint.proceed();
        System.out.println("环绕后通知==================");
        return object;

    }

    // 异常抛出通知
    public void afterThrowing(Throwable e){
        System.out.println("异常抛出通知================="+e);
    }

    // 最终通知
    public void finall(){
        System.out.println("最终通知=====================");
    }
}
