package com.haining820.service.impl;
/**
 * Created with IntelliJ IDEA
 * Description:
 * User: hn.yu
 * Date: 2022-08-09
 * Time: 0:47
 */

import com.haining820.service.AsyncContextAsyncService;
import org.apache.dubbo.rpc.AsyncContext;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.CompletableFuture;

/**
 * @ClassName AsyncContextAsyncServiceImpl
 * @Description: TODO
 */
public class AsyncContextAsyncServiceImpl implements AsyncContextAsyncService {

    @Override
    public String sayHelloAsync(String name) {
        final AsyncContext asyncContext = RpcContext.startAsync();
        new Thread(() -> {
            // 如果要使用上下文，则必须要放在第一句执行
            asyncContext.signalContextSwitch();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 写回响应
            asyncContext.write("Hello " + name + ", response from provider.");
        }).start();
        return null;
    }
}
