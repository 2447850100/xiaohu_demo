package com.xiaohu.reguler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {
    public static void main(String[] args) {

        String message = "小虎有个商品 淘宝电话号码是12321-3339991111，买了10本书，总花费了1201元";

        //String regex = "^(//d{5})-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}$";
        String regex = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);
        while (matcher.find()) {
            System.out.println("找到了:" + matcher.group());
        }

    }
}
