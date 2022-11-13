package com.xiaohu.sufa.array;

/**
 * 搜索二维矩阵，转为m x n的一维数组，再二分查找  index = row*n+cln
 */
public class searchMatrix {
    public static void main(String[] args) {
    int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        searchMatrix searchMatrix = new searchMatrix();
        boolean b = searchMatrix.searchMatrixFlag(matrix, 70);
        String matrixElement = searchMatrix.searchMatrixElement(matrix, 30);
        System.out.println("b = " + b);
        System.out.println("matrixElement = " + matrixElement);
    }

    /**
     * 确定有该目标元素 返回true/false
     * @param matrix 二维数组
     * @param target 目标元素
     */
    public boolean searchMatrixFlag(int[][] matrix, int target) {
        //二维数组总行
        int m = matrix.length;
        //空二维数组
        if (m == 0) return false;
        //二维数组总列
        int n = matrix[0].length;
        //转为一维数组
        int arrayLength = m * n;
        //定义两指针 左右指针
        int lp = 0;
        int rp = arrayLength - 1;
        //二分查找
        while (lp <= rp) {

            int mid = (lp + rp) >> 1;
            //这里是获取二维数组中间元素  行row = index/总列
            int midElement = matrix[mid / n][mid % n];
            if (midElement < target) {
                lp = mid + 1;
            } else if (midElement > target) {
                rp = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
    public String searchMatrixElement(int[][] matrix, int target) {
        //二维数组总行
        int m = matrix.length;

        //空二维数组
        if (m == 0) return null;
        //二维数组总列
        int n = matrix[0].length;

        //转为一维数组
        int arrayLength = m * n;
        //定义两指针 左右指针
        int lp = 0;
        int rp = arrayLength - 1;
        //二分查找
        while (lp <= rp) {

            int mid = (lp + rp) >> 1;
            //这里是获取二维数组中间元素  行row = index/总列
            int midElement = matrix[mid / n][mid % n];
            if (midElement < target) {
                lp = mid + 1;
            } else if (midElement > target) {
                rp = mid - 1;
            } else {
                //找到该元素 转为坐标
                int row = mid / n;
                int cal = mid % n;
                String format = String.format("该元素的坐标为: (%x,%x)", row, cal);
                System.out.println("format = " + format);
                return "(" + row+","+cal+")";
            }
        }
       return null;
    }
}
