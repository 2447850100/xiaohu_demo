package com.xiaohu.juc.futureTaskJuc;

public class Test {
    public static void main(String[] args) {
        int b = 0;
        int d = 0;
        int index= 0;
        for (int i = 0; i < 100; i++) {
            if (index == 32) {
                b = 0;
                index=0;
            }
            index++;
            b++;
            d++;
            System.out.println("code unsigned char temp" + b + "[]=" + "A00" + d + "");
        }
    }
}
