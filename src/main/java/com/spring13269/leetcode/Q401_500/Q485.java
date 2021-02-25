package com.spring13269.leetcode.Q401_500;

/**
 * Q485
 *
 * @author : zengle.huang@hand-china.com 2021/2/18
 */
public class Q485 {
    /**
     * 给定一个二进制数组， 计算其中最大连续 1 的个数。
     *
     * 示例：
     * 输入：[1,1,0,1,1,1]
     * 输出：3
     * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
     *
     * 提示：
     * 输入的数组只包含 0 和 1 。
     * 输入数组的长度是正整数，且不超过 10,000。
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                result = Math.max(result, count);
            } else {
                count=0;
            }
        }
        return Math.max(result, count);
    }
}
