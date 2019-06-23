package com.evan.aspectJ.demo1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
切面类
 */
@Aspect
public class MyAspectAnno {

    //所有方法前置增强
    //@Before(value = "execution(* com.evan.aspectJ.demo1.ProductDao.*(..))")
    //save方法前置增强
    @Before(value = "execution(* com.evan.aspectJ.demo1.ProductDao.save(..))")
    public void befor(){
        System.out.println("前置通知============");
    }
}
