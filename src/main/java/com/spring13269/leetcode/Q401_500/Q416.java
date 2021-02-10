package com.spring13269.leetcode.Q401_500;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Q416
 *
 * @author : zengle.huang@hand-china.com 2020/10/11
 */
public class Q416 {
    /**
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * 注意:
     * 每个数组中的元素不会超过 100
     * 数组的大小不会超过 200
     * 示例 1:
     * 输入: [1, 5, 11, 5]
     * 输出: true
     * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
     *  
     * 示例 2:
     * 输入: [1, 2, 3, 5]
     * 输出: false
     * 解释: 数组不能分割成两个元素和相等的子集.
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if (sum%2 != 0) {
            return false;
        }
        int half = sum/2;
        int halfSum = 0;
        /*if (canEquals(0, nums, halfSum, half)) {
            return true;
        }*/
        if (canEquals( nums, half)) {
            return true;
        }
        return false;
    }

    public boolean canEquals(int[] nums, int target) {
        //Set<Integer> mayCount = new HashSet<>(target);
        /*int[] origin = new int[target+1];
        for (int i: nums) {
            int[] mayCount = Arrays.copyOf(origin, origin.length);
            for (int j = 0; j < mayCount.length; j++) {
                if (mayCount[j] == 1) {
                    if (j + i == target) {
                        return true;
                    } else if (j + i < target) {
                        origin[j + i] = 1;
                    }
                }
            }
            origin[i] = 1;
        }*/
        boolean[] origin = new boolean[target + 1];
        for (int i: nums) {
            boolean[] mayCount = Arrays.copyOf(origin, origin.length);
            for (int j = 0; j < mayCount.length; j++) {
                if (mayCount[j]) {
                    if (j + i == target) {
                        return true;
                    } else if (j + i < target) {
                        origin[j + i] = true;
                    }
                }
            }
            if (i == target) {
                return true;
            } else if (i > target) {
                return false;
            } else {
                origin[i] = true;
            }
        }
        return false;
    }
    public boolean canEquals(int i, int[] nums, int count, int target) {
        if (count > target) {
            return false;
        }
        if (count == target) {
            return true;
        }
        for (; i < nums.length; i++) {
            if (canEquals(i+1, nums, count+nums[i], target)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[]  args) {
        Q416 q = new Q416();
        /*boolean result = q.canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,98});*/
        //boolean result = q.canPartition(new int[]{1,3,4,5,6,1,2,3,1,2,3,3});
        boolean result = q.canPartition(new int[]{1,2,5});
        System.out.println(result);
    }
}
