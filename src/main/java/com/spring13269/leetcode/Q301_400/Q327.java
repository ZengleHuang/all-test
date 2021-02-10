package com.spring13269.leetcode.Q301_400;

/**
 * Q327
 *
 * @author : zengle.huang@hand-china.com 2020/11/7
 */
public class Q327 {
    /**
     * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
     * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
     *
     * 说明:
     * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
     *
     * 示例:
     * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
     * 输出: 3
     * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
     */

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] counts = new long[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                counts[j] += nums[i];
                if (counts[j] >= lower && counts[j] <= upper) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        //[-2147483647,0,-2147483647,2147483647]
        //-564
        //3864
        Q327 q = new Q327();
        //System.out.println(q.countRangeSum(new int[]{-2,5,-1}, -2,2));
        System.out.println(q.countRangeSum(new int[]{-2147483647,0,-2147483647,2147483647}, -564,3864));
    }
}
