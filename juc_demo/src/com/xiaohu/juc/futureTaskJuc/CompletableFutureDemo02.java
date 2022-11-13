package com.xiaohu.juc.futureTaskJuc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo02 {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 1;
                }).thenApply(f -> f + 3)
                .whenComplete((v, e) -> {
                    if (e == null) System.out.println("result :" + v);
                }).exceptionally(e -> {
                    e.printStackTrace();
                    return null;
                });
        System.out.println("诛仙城----------");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}