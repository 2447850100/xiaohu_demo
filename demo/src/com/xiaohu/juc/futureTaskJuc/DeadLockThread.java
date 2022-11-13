package com.xiaohu.juc.futureTaskJuc;

public class DeadLockThread implements Runnable{

    private String lockA;
    private String lockB;

    public DeadLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "获取"+lockA+"锁，尝试获取" + lockB);
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "获取"+lockB+"锁，尝试获取" + lockA);
            }
        }
    }
}
