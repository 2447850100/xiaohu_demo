package com.xiaohu.reguler;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Test4 {
    public static void main(String[] args) {

        int[] array = {1,1,3,4,2,2,5,7};
//        String s = Arrays.toString(array);
//        System.out.println("s = " + s);
//        //去除[ ] , 空格
//        String regStr = "([\\[\\],\\s])";
//        s = s.replaceAll(regStr, "");
//        System.out.println("s = " + s);
        //去除重复数字并排序 1,2,3,4,5
        String s = Arrays.toString(array);
        //s = Pattern.compile("([\\[\\],\\s])").matcher(s).replaceAll("");
        s = s.replaceAll("([\\[\\],\\s])","");
        System.out.println("s = " + s);
        s = Pattern.compile("(.)\\1+").matcher(s).replaceAll("$1");
        System.out.println("s = " + s);
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);

    }
}
