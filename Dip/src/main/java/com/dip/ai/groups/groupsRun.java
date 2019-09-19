package com.dip.ai.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class groupsRun {
    groupsOnMethod groupsServer = new groupsOnMethod();
    @Test
    public void Run(){
        groupsServer.test1();
        groupsServer.test2();
    }
    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端组运行之前的方法");
    }
    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("这是服务端组运行之后的方法");
    }
}
