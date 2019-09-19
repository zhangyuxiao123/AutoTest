package com.dip.ai;

import org.testng.annotations.Test;

public class Exception {
    /**
     * 什么时候会用到异常测试？
     * 在我们期望结果为某一个异常的时候
     * 比如：我们传入了某些个不合法的参数，程序抛出了异常
     * 也就是说我们的预期结果就是这个异常
     */
    //失败的异常测试
    /* @Test(expectedExceptions =RuntimeException.class)
    public void failOnException(){
        System.out.println("失败的异常测试");
    } */

    //成功的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailtion(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();
    }
}
