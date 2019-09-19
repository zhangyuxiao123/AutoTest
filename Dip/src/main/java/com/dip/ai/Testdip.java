package com.dip.ai;

import org.testng.annotations.*;

public class Testdip {

    //最后执行的注解
    @AfterMethod
    public void afterMethod(){
        System.out.println("在所用用例之后执行的用例");
    }
    //第一条用例
    @Test
    public void Annotations(){
    System.out.println("这是第一条用例");
    }
    //第二条测试用例
    @Test
    public void Test2(){
        System.out.println("这是第二条测试用例");
    }
    //第三条测试用例
    @Test
    public void Test3(){
        System.out.println("这是第三条测试用例");
    }
    //首先执行的注解
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是在所有之前执行的用例");
    }
    //在类之前运行的测试套件
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite测试套件");
    }
    //在类之后运行的测试套件
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite测试套件");
    }


}
