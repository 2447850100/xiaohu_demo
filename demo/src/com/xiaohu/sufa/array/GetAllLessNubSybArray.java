package com.xiaohu.sufa.array;

import java.util.LinkedList;

public class GetAllLessNubSybArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int num = GetAllLessNubSybNum(arr, 3);
        System.out.println("num = " + num);

    }

    private static int GetAllLessNubSybNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int result = 0;
        LinkedList<Integer> minQueue = new LinkedList<>();
        LinkedList<Integer> maxQueue = new LinkedList<>();
        while (left <= arr.length) {
            while (right <= arr.length) {
                while (!minQueue.isEmpty() && arr[minQueue.peekLast()] >= arr[right]) {
                    minQueue.pollLast();
                }
                minQueue.addLast(arr[right]);
                while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] <= arr[right]) {
                    maxQueue.pollLast();
                }
                maxQueue.addLast(arr[right]);
                if (!maxQueue.isEmpty() && !minQueue.isEmpty() && arr[maxQueue.getFirst()] - arr[minQueue.getFirst()] > num) {
                    break;
                }
                right++;
            }
            result += right - left;
            if (!maxQueue.isEmpty() && maxQueue.peekFirst() == left) {
                maxQueue.pollFirst();
            }
            if (!minQueue.isEmpty() && minQueue.peekFirst() == left) {
                minQueue.pollFirst();
            }
            left++;
        }
        return result;
    }
}
