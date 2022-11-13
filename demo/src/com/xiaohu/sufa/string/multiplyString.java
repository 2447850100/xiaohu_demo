package com.xiaohu.sufa.string;

public class multiplyString {
    public static void main(String[] args) {
        multiplyString multiplyString = new multiplyString();
        String s1 = "123";
        String s2 = "456";
        System.out.println(multiplyString.multiply(s1, s2));
    }

    public String multiply(String num1, String num2) {
        //0和任何相乘等于0
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        //定义一个存个位和进位数组 个位 resultArray[i+j+1] 进位resultArray[i+j] 有可能进位之前有值，需要取出来 再相加填充进去
        int[] resultArray = new int[num1.length() + num2.length()];
        //取出num1和num2每个字节相乘
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';

                int multiply = n1 * n2;
                //乘积相加
                int sum = multiply + resultArray[i + j + 1];
                resultArray[i + j + 1] = sum % 10;
                //进位 之前可能有值，取出来相加，再填充 个位不用
                resultArray[i + j] += sum / 10;
            }
        }
        //最后处理数组数据
        //如果首位数字为0 从索引1开始 否则从0开始
        StringBuilder stringBuilder = new StringBuilder();
        int start = resultArray[0] == 0 ? 1 : 0;
        for (int i = start; i < resultArray.length; i++) {
            stringBuilder.append(resultArray[i]);
        }
        return stringBuilder.toString();
    }
}
