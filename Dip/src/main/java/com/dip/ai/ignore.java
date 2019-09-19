package com.dip.ai;


import org.testng.annotations.Test;

public class ignore {
    @Test(enabled = true)
    public void ignore1(){
        System.out.println("ignore1执行");
    }
    //忽略测试
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2执行");
    }
    @Test
    public void ignore3(){
        System.out.println("ignore3执行");
    }
}
