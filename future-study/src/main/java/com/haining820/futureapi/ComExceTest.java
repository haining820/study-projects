package com.haining820.futureapi;
/**
 * Created with IntelliJ IDEA
 * Description:
 * User: hn.yu
 * Date: 2022-07-22
 * Time: 15:25
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ComExceTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        try {
            future.complete("test success");
        }catch (Exception e){
            future.completeExceptionally(e);
        }
        System.out.println(future.get());
    }
}
