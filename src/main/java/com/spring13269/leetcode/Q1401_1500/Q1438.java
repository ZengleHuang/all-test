package com.spring13269.leetcode.Q1401_1500;

import java.util.Arrays;

/**
 * Q1438
 *
 * @author : zengle.huang@hand-china.com 2021/2/21
 */
public class Q1438 {
    /**
     * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
     * 如果不存在满足条件的子数组，则返回 0 。
     *  
     * 示例 1：
     * 输入：nums = [8,2,4,7], limit = 4
     * 输出：2
     * 解释：所有子数组如下：
     * [8] 最大绝对差 |8-8| = 0 <= 4.
     * [8,2] 最大绝对差 |8-2| = 6 > 4.
     * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
     * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
     * [2] 最大绝对差 |2-2| = 0 <= 4.
     * [2,4] 最大绝对差 |2-4| = 2 <= 4.
     * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
     * [4] 最大绝对差 |4-4| = 0 <= 4.
     * [4,7] 最大绝对差 |4-7| = 3 <= 4.
     * [7] 最大绝对差 |7-7| = 0 <= 4.
     * 因此，满足题意的最长子数组的长度为 2 。
     * 示例 2：
     * 输入：nums = [10,1,2,4,7,2], limit = 5
     * 输出：4
     * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
     * 示例 3：
     * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
     * 输出：3
     *  
     * 提示：
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^9
     * 0 <= limit <= 10^9
     */
    public int longestSubarray(int[] nums, int limit) {
        int length = nums.length;
        int[] numLength = new int[length];
        int[] numMax = new int[length];
        int[] numMin = new int[length];
        for (int i = 0; i < nums.length; i++) {
            numMax[i] = i;
            numMin[i] = i;
        }
        for (int i = 0; i < length; i++) {
            int j = i+1;
            if (i >= 1) {
                int lastMaxNum = Math.max(numMax[i -1], numMin[i-1]);
                // 大于上一个最大值，导致超过
                if (nums[lastMaxNum + 1] > nums[numMax[i - 1]] && (numMin[i-1] >= i-1)) {
                    i = numMin[i - 1] + 1;
                    numMax[i] = numMax[i-1];
                    numMin[i] = numMin[i-1];
                    //continue;
                    j = Math.max(numMax[i], numMin[i]);
                }
                if (nums[lastMaxNum + 1] < nums[numMin[i - 1]] && (numMax[i-1] >= i-1)) {
                    i = numMax[i - 1] + 1;
                    numMax[i] = numMax[i-1];
                    numMin[i] = numMin[i-1];
                    //continue;
                    j = Math.max(numMax[i], numMin[i]);
                }
            }
            for (; j < length; j++) {
                if (nums[j] <= nums[i]) {
                    if (nums[numMax[i]] - nums[j] > limit) {
                        break;
                    }
                    if (nums[j] <= nums[numMin[i]]) {
                        numMin[i] = j;
                    }
                }
                if (nums[j] >= nums[i]) {
                    if (nums[j] - nums[numMin[i]] > limit) {
                        break;
                    }
                    if (nums[j] >= nums[numMax[i]]) {
                        numMax[i] = j;
                    }
                }
            }
            numLength[i] = j - i;
            if (j >= length) {
                break;
            }
        }
        System.out.println(Arrays.toString(numMax));
        System.out.println(Arrays.toString(numMin));
        System.out.println(Arrays.toString(numLength));
        int result = 0;
        for (int i = 0; i < length; i++) {
            result = Math.max(result, numLength[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Q1438 q = new Q1438();
        //q.longestSubarray(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,11}, 2);
        q.longestSubarray(new int[]{7,40,10,10,40,39,96,21,54,73,33,17,2,72,5,76,28,73,59,22,100,91,80,66,5,49,26,45,13,27,74,87,56,76,25,64,14,86,50,38,65,64,3,42,79,52,37,3,21,26,42,73,18,44,55,28,35,87}, 63);
    }
}
