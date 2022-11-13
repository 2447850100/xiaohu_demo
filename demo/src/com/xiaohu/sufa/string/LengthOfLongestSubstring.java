package com.xiaohu.sufa.string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static  int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> hash = new HashMap<>();
        int start = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer index = hash.get(s.charAt(i));
            if (index != null && index >= start) {
                start = index + 1;

            }
            if ((i - start + 1) > maxLength) {
                maxLength = i - start + 1;
            }
            hash.put(s.charAt(i), i);
        }
        return maxLength;
    }
}
