package com.dip.ai.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterTest {
    //参数化测试
    @Test
    @Parameters({"name","age"})
    public void paramterTest1(String name,int age){
        System.out.println("姓名 = " + name +"；年龄 = "+ age + "岁！");
    }
}
