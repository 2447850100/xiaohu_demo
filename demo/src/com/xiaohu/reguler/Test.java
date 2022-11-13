package com.xiaohu.reguler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        String date = "20220905";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date parse = simpleDateFormat.parse(date);
        System.out.println("parse = " + parse);
        long time = parse.getTime();
        System.out.println("time = " + time);


    }
}
