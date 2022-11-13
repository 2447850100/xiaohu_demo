package com.xiaohu.sufa.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 获取滑动窗口最大值max 取最大值  所以队列从大->小 最后头部第一个为最大值
 * 获取滑动窗口最小值min 取最小值 所以队列小->大 最后头部第一个为最小值
 */
public class GetMaxWindows {

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] maxWindows = getMaxWindows(arr, 3);
        System.out.println("maxWindows = " + Arrays.toString(maxWindows));
    }

    private static int[] getMaxWindows(int[] arr, int windowsNum) {

        if (arr.length < windowsNum || arr.length == 0 || windowsNum < 1) {
            return new int[0];
        }
        int[] result = new int[arr.length + 1 - windowsNum];
        int index = 0;
        LinkedList<Integer> qIndex = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            //如果窗口当前索引的值大于了队列中的值，队列中的值从尾部弹出
            while (!qIndex.isEmpty() && arr[qIndex.peekLast()] <= arr[i]) {
                qIndex.pollLast();
            }
            qIndex.addLast(i);
            //如果窗口过期了，只有i当前索引大于等于了windowsNum 窗口需要释放
            if (!qIndex.isEmpty() && qIndex.peekFirst() == i - windowsNum) {
                qIndex.pollFirst();
            }
            //找到一个最大值 只要滑动窗口满足了windowsNum就开始找最大值，i是索引所以需要+1，头部第一个元素就是最大值
            if (i >= windowsNum - 1 && !qIndex.isEmpty()) {
                result[index] = arr[qIndex.peekFirst()];
                index++;
            }
        }
        return result;
    }
}
