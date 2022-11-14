package com.xiaohu.juc.tools;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 滑动窗口限流
 */
public class WindowsLimiter {

    private static LinkedList<Thread> threadLinkedList = new LinkedList<>();
    private static LinkedList<Integer> WindowsLimiter = new LinkedList<>();

    private static Queue<Integer> queue = new ArrayBlockingQueue(100);

    private static int size = 10;

    private static int index = 0;

    public static void main(String[] args)  {
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new Task("i_" + i));
            setRequest(thread);
        }
    }

    private static void setRequest(Thread task) {
        threadLinkedList.add(task);
        WindowsLimiter.add(index);
        if (WindowsLimiter.peekFirst() == index - size) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            while (!WindowsLimiter.isEmpty()) {
                WindowsLimiter.pollFirst();
            }
        }
        while (!threadLinkedList.isEmpty()) {
             threadLinkedList.pop().start();
        }
        index++;
    }
}
