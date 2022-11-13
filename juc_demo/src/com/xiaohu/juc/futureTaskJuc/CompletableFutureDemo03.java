package com.xiaohu.juc.futureTaskJuc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class CompletableFutureDemo03 {
    static List<Store> list = Arrays.asList(
            new Store("taobao"),
            new Store("jingdong"),
            new Store("dangdangwang"),
            new Store("pdd"),
            new Store("11111"),
            new Store("22222"),
            new Store("222221"),
            new Store("222222"),
            new Store("222223"),
            new Store("22222"));

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        for (String mysql : getPriceByStep(list, "mysql")) {
            System.out.println("mysql = " + mysql);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("(end1-start1) : " + (end1 - start1) + "ms");
        System.out.println();

        long start2 = System.currentTimeMillis();
        for (String mysql : getPriceByAsyn(list, "mysql")) {
            System.out.println("mysql = " + mysql);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("(end2-start2) ： " + (end2 - start2) + "ms");
    }

    public static double calcPrice(String name) {

        return ThreadLocalRandom.current().nextDouble() * 2 + name.charAt(0);
    }

    public static List<String> getPriceByStep(List<Store> list, String name) {
        return list.stream().map(store -> String.format(name + "in %s price is %.2f", store.getName(), calcPrice(name)))
                .collect(Collectors.toList());
    }

    public static List<String> getPriceByAsyn(List<Store> list, String name) {
        return list.stream()
                .map(store -> CompletableFuture.supplyAsync(() -> String.format(name + "in %s price is %.2f", store.getName(), calcPrice(name))))
                .toList()
                .stream()
                .map(CompletableFuture::join).collect(Collectors.toList());
    }

    static class Store {
        private String name;

        public String getName() {
            return name;
        }

        public Store(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
