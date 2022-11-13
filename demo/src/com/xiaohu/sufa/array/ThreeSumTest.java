package com.xiaohu.sufa.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和==0 不能重复
 * -1，-4，4，5，3      sort: -4，-1，3,4，5     result:[-4,-1,5]
 * 思路:定义一个最小数据为核心+左右指针 lp,rp
 * sum=nums[i] + nums[lp]+nums[rp]
 * 1.如果核心数据 nums[i]>0 break
 * 2.如果nums[i] == nums[i-1] continue
 * 3.如果sum>0 rp--
 * 4.如果sum<0 lp++
 * 5.如果sum=0 {
 * 5.1: 找到一组，左右指针变化 继续判断是否有重复元素
 * }
 */
public class ThreeSumTest {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1,-4};
        //int[] nums = {1, -4, 4, 5, 3};
        List<List<Integer>> result = ThreeSum(nums);
        System.out.println("result = " + result);
    }


    public static List<List<Integer>> ThreeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        //1.排序
        Arrays.sort(nums);

        //2.遍历核心，也就是基础数据 以最小的数据为核心
        for (int i = 0; i < n; i++) {
            //3. >0 即 nums[i]>0 代表循环结束 break
            if (nums[i] > 0) break;
            //4.前面以遍历该核心，无需再遍历
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //5.常规情况 定义左右指针，左指针i的后一位，右指针最后最大的那位
            int lp = i + 1;
            int rp = n - 1;
            while (lp < rp) {
                int sum = nums[lp] + nums[i] + nums[rp];
                // sum == 0
                if (sum == 0) {
                    //找到一组解
                    result.add(Arrays.asList(nums[i], nums[lp], nums[rp]));
                    lp++;
                    rp--;
                    //如果移动之后出现重复元素 跳过 这两步不影响，只是优化时间
                    while (lp < rp && nums[lp] == nums[lp - 1]) lp++;
                    while (lp < rp && nums[rp] == nums[rp + 1]) rp--;
                } else if (sum < 0) {
                    lp++;
                } else {
                    rp--;
                }
            }
        }
        return result;
    }
}
