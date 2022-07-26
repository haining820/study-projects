package com.haining820.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA
 * Description: 实现Callable接口，输出当前线程名称
 * User: hn.yu
 * Date: 2022-07-22
 * Time: 11:20
 */

public class CallableTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Task->"+Thread.currentThread().getName());

        TimeUnit.SECONDS.sleep(1);
//        int a = 1 / 0;    // 异常
        return "task done";
    }
}
