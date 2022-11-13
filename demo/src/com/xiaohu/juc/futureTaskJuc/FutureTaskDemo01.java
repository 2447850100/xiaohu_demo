package com.xiaohu.juc.futureTaskJuc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo01 {
    public static void main(String[] args) {

            Integer integer = new Integer(1);
            Integer i = 1;
            int a = 1;
            System.out.println(a==i);
            System.out.println(a==integer);
            System.out.println(i == integer);

    }
}
