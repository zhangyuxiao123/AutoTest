package com.dip.ai.mulThread;

import org.testng.annotations.Test;

public class multiThreadOnXml {
    @Test
    public void test1(){
        System.out.printf("多线程ID: %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test2(){
        System.out.printf("多线程ID: %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test3(){
        System.out.printf("多线程ID: %s%n",Thread.currentThread().getId());
    }
}
