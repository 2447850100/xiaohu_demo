package com.xiaohu.reguler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
        //String message = "https://www.bilibili.com/4374/video/BV1Eq4y1E79W?p=17&spm_id_from=pageDriver&vd_source=be00594123799f5d47dea41a161b";
        String message = "https://www.bilibili.com/video/BV1tV4y1H72k?spm_id_from=333.1007.tianma.2-1-4.click";
        //验证url / +([\w-])+(/)?([\w\s].*)$
        Pattern compile = Pattern.compile("^((https|http)://)?([\\w-]+\\.)+(\\w)+(/)?([\\w\s]).*");
        Matcher matcher = compile.matcher(message);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
