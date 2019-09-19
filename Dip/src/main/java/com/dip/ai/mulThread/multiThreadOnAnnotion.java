package com.dip.ai.mulThread;

import org.testng.annotations.Test;

public class multiThreadOnAnnotion {
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("多线程ID: %s%n",Thread.currentThread().getId());
    }
}
