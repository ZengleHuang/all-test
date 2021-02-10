package com.spring13269.leetcode.Q0_100;

/**
 * FirstMissingPositive41 description
 *
 * @author zengle.huang@hand-china.com  2019/11/28
 * @version 1.0
 */
public class FirstMissingPositive41 {
    public static int firstMissingPositive(int[] nums) {
        int max = 1, min = Integer.MAX_VALUE;
        for (int i =0 ;i< nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] > 0 && nums[i] < min) {
                min = nums[i];
            }
        }
        if (min > 1) {
            return 1;
        } else {
            int[] nums1 = new int[nums.length];
            for (int i = 0; i<nums.length; i++) {
                if (nums[i] >0 && nums[i] <= nums.length) {
                    nums1[nums[i] - 1] = 1;
                }
            }
            for (int i =0; i<nums1.length; i++) {
                if (nums1[i] != 1) {
                    return ++i;
                }
            }
            return nums1.length +1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
}
