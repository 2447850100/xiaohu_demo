package com.xiaohu.juc.futureTaskJuc;

import java.util.concurrent.*;

public class CompletableFutureDemo01 {
    public static void main(String[] args) {

        CompletableFuture<Void> future = new CompletableFuture<>().runAsync(() -> System.out.println(Thread.currentThread().getName() + "\t" + "come in"));

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 5, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque(20), new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<Void> async = new CompletableFuture<>().runAsync((Runnable) () -> System.out.println(Thread.currentThread().getName() + "\t" + "xxxx"), poolExecutor);

        poolExecutor.shutdown();
    }

}
