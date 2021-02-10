package com.spring13269.leetcode.Q601_700;

import java.util.Arrays;

/**
 * Q628
 *
 * @author : zengle.huang@hand-china.com 2021/1/20
 */
public class Q628 {
    /**
     * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
     *
     * 示例 1:
     * 输入: [1,2,3]
     * 输出: 6
     * 示例 2:
     * 输入: [1,2,3,4]
     * 输出: 24
     * 注意:
     * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
     * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
     */
    public int maximumProduct(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        /*Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int length = nums.length;
        if (nums[length -1] >0 && nums[0] * nums[1] > nums[length-3]*nums[length-2]) {
            return nums[0] * nums[1] * nums[length-1];
        } else {
            return nums[length-1] * nums[length-2] * nums[length-3];
        }*/
        int[] max = new int[]{-1000, -1000, -1000};
        int[] min = new int[]{1000, 1000, 1000};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max[2]) {
                max[0] = max[1];
                max[1] = max[2];
                max[2] = nums[i];
            } else if (nums[i] > max[1]) {
                max[0] = max[1];
                max[1] = nums[i];
            } else if (nums[i] > max[0]) {
                max[0] = nums[i];
            }
            if (nums[i] < min[2]) {
                min[0] = min[1];
                min[1] = min[2];
                min[2] = nums[i];
            } else if (nums[i] < min[1]) {
                min[0] = min[1];
                min[1] = nums[i];
            } else if (nums[i] < min[0]) {
                min[0] = nums[i];
            }
        }
        //return max[0] * max[1] * max[2];
        return (max[2] > 0 && min[2] * min[1] > max[0] * max[1]) ? min[2] * min[1] * max[2] : max[0] * max[1] * max[2];
    }
}
