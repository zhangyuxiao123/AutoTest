package com.dip.ai.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider="data")
    public void testDataProvider(String name,int age){
        System.out.println(name+age+"岁了");
    }
    @DataProvider(name ="data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"张三",15},
                {"李四",16},
                {"王五",18}
        };
        return o;
    }
    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println(name+age+"岁了");
    }
   @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println(name+age+"岁了");
    }
    @DataProvider(name ="methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result=null;
         if(method.getName().equals("test1")){
             result = new Object[][]{
                     {"夫差",1012},
                     {"勾践",1000}
             };
             return result;
         }else if (method.getName().equals("test2")){
             result =new Object[][]{
                     {"赵云",673},
                     {"关羽",680}
             };
             return result;
        }
         return result;
    }
}
