package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouxufeng
 * @version 1.0
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
@SuppressWarnings({"all"})
public class Number1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] ints = twoSumHash(nums, 9);

        for (Integer num:ints) {
            System.out.println(num);
        }
    }

    /**
     * 两个 for 遍历查找两数之和
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumFor(int[] nums, int target) {
        int i,j;
        for(i=0;i<nums.length;i++) {
            for(j=i+1;j<nums.length;++j) {
                if(nums[i]+nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }

        return new int[0];
    }

    /**
     * 使用 hashmap 查找两数之和
     * 1. 记录数组值为键值,下标值存放到 hashMap 中
     * 2. 差值存在于hashMap中就返回两数下标,不存在继续循环
     * 个人见解: 每个数最多循环一次,减少了程序执行时间
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumHash(int[] nums, int target) {
        Map<Integer,Integer> hashtable = new HashMap<>();
        int size = nums.length;

        for(int i = 0; i<size;i++) {
            if(hashtable.containsKey(target-nums[i])) {
                return new int[]{hashtable.get(target-nums[i]), i};
            } else {
                hashtable.put(nums[i], i);
            }
        }

        return new int[0];
    }
}
