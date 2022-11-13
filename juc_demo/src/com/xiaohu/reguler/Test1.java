package com.xiaohu.reguler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

    public static void main(String[] args) {
        String message = "1112c(aaaa(aaa";
        Pattern compile = Pattern.compile("([0-9]){4}");
        Matcher matcher = compile.matcher(message);
        while (matcher.find()) {
            String group = matcher.group(1);
            System.out.println("group = " + group);
        }


    }
}
