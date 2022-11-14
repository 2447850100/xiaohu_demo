package com.xiaohu.juc.tools;

public class Task extends Thread{

    public Task(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(String.format("当前线程获取zzzzzzz%s",Thread.currentThread().getName()));
    }
}
