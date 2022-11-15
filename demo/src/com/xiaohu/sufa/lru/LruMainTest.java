package com.xiaohu.sufa.lru;

/**
 * @Version 1.0
 * @Author huqiang
 * @Description LruMainTest
 * @Date 2022/11/15 13:02
 **/
public class LruMainTest {
    public static void main(String[] args) {
        LruManager<Object, Object> manager = new LruManager<>(3);
        Object string = manager.getOrDefault("xiaohu", -1);
        System.out.println("string = " + string);
        manager.put(1, "hello1");
        manager.put(2, "hello2");
        manager.put(3, "hello3");
        Object number = manager.getOrDefault(2, "");
        System.out.println("orDefault = " + number);
        System.out.println("lruTest = " + manager.getHead());


        System.out.println("--------------lru-------------");
        manager.put("xxx","hello4");
        System.out.println("lruTest = " + manager.getHead());
        Object aDefault = manager.getOrDefault("xxx", -1);
        System.out.println("aDefault = " + aDefault);

    }
}
