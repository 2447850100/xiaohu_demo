package com.xiaohu.juc.futureTaskJuc;

public class DeadLockDemoMain {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        Thread thread1 = new Thread(new DeadLockThread(a, b), "a线程");
        Thread thread2 = new Thread(new DeadLockThread(b,a), "b线程");
        thread1.start();
        thread2.start();
    }
}
