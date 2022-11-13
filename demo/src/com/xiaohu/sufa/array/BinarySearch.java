package com.xiaohu.sufa.array;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1, 3, 3, 4, 5,5};
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.binarySearch(array,5);
    }

    /**
     * 二分查找适合读多写少有序数组
     */
    public void binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        if (array[0] > key || key > array[high]) {
            throw new IllegalArgumentException();
        }
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (array[mid] < key) {
                low = mid + 1;
            } else if (array[mid] > key) {
                high = mid - 1;
            } else {
                String message = String.format("查找到的key:%s的索引位置为:%x", key, mid);
                System.out.println(message);
                return;
            }
        }
        String format = String.format("未找到key:%s", key);
        System.out.println(format);
    }
}
