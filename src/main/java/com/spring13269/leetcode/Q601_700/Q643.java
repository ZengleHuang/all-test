package com.spring13269.leetcode.Q601_700;

/**
 * Q643
 *
 * @author : zengle.huang@hand-china.com 2021/2/4
 */
public class Q643 {
    /**
     * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
     *
     * 示例：
     * 输入：[1,12,-5,-6,50,3], k = 4
     * 输出：12.75
     * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
     *
     * 提示：
     * 1 <= k <= n <= 30,000。
     * 所给数据范围 [-10,000，10,000]。
     */
    public double findMaxAverage(int[] nums, int k) {
        if (k > nums.length) {
            return 0;
        }
        double max = 0;
        double count = 0;
        for (int i = 0; i < k; i++) {
            count+=nums[i];
            max=count;
        }
        for (int i = k; i < nums.length; i++) {
            count = count + nums[i] - nums[i-k];
            max = Math.max(count, max);
            System.out.println(max);
        }
        return count/k;

    }

}
