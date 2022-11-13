package com.xiaohu.sufa.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class findDuplicate {

    public static void main(String[] args) {
        findDuplicate findDuplicate = new findDuplicate();
        int[] nums = {2,5,9,6,9,3,8,9,7,1};  // 1,3,3,4,2
        System.out.println(findDuplicate.findDuplicate3(nums));

    }

    public int findDuplicateHashMap1(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return nums[i];
            }
            hashMap.put(nums[i], i);
        }
        return -1;
    }


    public int findDuplicate2(int[] nums) {
//        int target = 0;
//        Arrays.sort(nums);
//        int lp = 0;
//        int rp = nums.length - 1;
//        while (lp <= rp) {
//            int mid = (lp + rp) >> 1;
//            if ((nums[mid] ^ target) == 0) {
//                return target;
//            }else if ((nums[mid] ^ target) < 0)
//        }
//        return -1;
        Arrays.sort(nums);
        int lp = 0;
        int rp = 1;
        for (int num : nums) {
            if ((nums[lp] ^ nums[rp]) == 0) {
                return num;
            }
            lp++;
            rp++;
        }
        return -1;
    }

    public int findDuplicate3(int[] nums) {
        // 形成链表环结构，链表节点当做数组索引 连接线当中 数组索引对应的值 当没有重复元素的时候就是直向链表，当数组有重复元素，就会出现相互引用，出席环
        // 定义快慢指针，快指针走两步，慢指针走一步
        //1.所以出现环的时候，快慢指针总会相遇，当相遇的时候，找到那个节点，这时候还无法确定此节点就是环入口节点

        //2.再定义两指针 before和after 一个从链表初始位置开始，一个以第一步相遇的节点开始进行环里步进，当两指针相遇就是入口处，通过走过的距离，数学证明推导得出 这入口处就是重复元素

        int slow = 0;
        int fast = 0;

        do {
            //走一步
            slow = nums[slow];
            //走两步
            fast = nums[nums[fast]];
        } while (slow != fast);
        //循环结束，代表快慢指针相遇
        //节点初始位置 重新定义指针
        slow  = 0;
        //节点相遇位置
        while (slow != fast) {
            //都每走一步
            slow = nums[slow];
            fast = nums[fast];
        }
        //循环结束，两节点相遇，此时索引指向就是重复值
        return fast;
    }
}
