package com.xiaohu.sufa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 获取一个数组中，左右最近的最小值数，通过栈先进后出，栈底->栈顶  小->大
 */
public class MinStrock {

    public static void main(String[] args) {
        //int[] arr = {3, 2, 1, 4, 5};
        int[] arr = {3, 2, 3, 5, 3,1 };
        int[][] minStrock = getMinStrock(arr);
        System.out.println("minStrock = " + Arrays.deepToString(minStrock));
    }

    /**
     * 返回 二维数组，左，右的最小值
     *
     * @param arr
     * @return
     */
    private static int[][] getMinStrock(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int index = 0;
        //存放栈元素索引集合 栈底->栈顶  小->大
        Stack<List<Integer>> stack = new Stack<>();
        int[][] result = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            //如果栈元素不为空&& 栈顶的元素值大于当前索引对应的值，需要栈弹出 左边的最小值为压的元素，右边是当前索引
            //取一个元素比较即可 stack.peek().get(0) 因为集合内存的相同的值
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> list = stack.pop();
                //如果当前栈为空了，代表左边没有值，否则取最近的一个元素
                int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer ele : list) {
                    result[index][0] = leftIndex;
                    result[index][1] = i;
                    index++;
                }
            }
            //如果栈不为空 && 并且有重复元素了
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }

        }
        //最后整个数组遍历完，栈中还有元素，
        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer ele : pop) {
                result[index][0] = leftIndex;
                result[index][1] = -1;
                index++;
            }
        }
        return result;
    }

}
