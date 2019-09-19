package com.dip.ai;

import org.testng.annotations.Test;

public class timeOutTest {
    @Test(timeOut = 3000)
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

}
