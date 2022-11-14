package com.xiaohu.sufa.array;

import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @Version 1.0
 * @Author huqiang
 * @Description MovingAverage
 * @Date 2022/11/14 11:19
 **/
public class MovingAverage {

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        double next = movingAverage.next(1);
        System.out.println("next = " + next);
        double next1 = movingAverage.next(10);
        System.out.println("next1 = " + next1);
        double next2 = movingAverage.next(3);
        System.out.println("next2 = " + next2);
        double next3 = movingAverage.next(5);
        System.out.println("next3 = " + next3);
    }

    private static int size;

    private static int index;

    private static LinkedList<Integer> list;

    double sum = 0;

    static LinkedList<Integer> queue = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.size = size;
        list = new LinkedList<>();
    }

    public double next(int val) {

        list.addLast(val);
        queue.add(index);

        if (queue.peekFirst() == index - size) {
            queue.pollFirst();
        }
        sum+=val;
        index++;
        return sum/queue.size();
    }

}
