package com.xiaohu.juc.tools;

import java.util.concurrent.Semaphore;

public class SemaphoreRunner {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Task(semaphore, "i_" + i));
            thread.start();
        }
    }

    static class Task extends Thread {
        private Semaphore semaphore;
        public Task(Semaphore semaphore,String name) {
            super(name);
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(String.format("当前线程获取%s",Thread.currentThread().getName()));
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                semaphore.release();
            }
        }
    }
}
