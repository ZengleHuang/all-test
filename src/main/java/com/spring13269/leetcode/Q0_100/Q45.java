package com.spring13269.leetcode.Q0_100;

/**
 * Q45
 *
 * @author : zengle.huang@hand-china.com 2021/1/15
 */
public class Q45 {
    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 示例:
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 说明:
     * 假设你总是可以到达数组的最后一个位置。
     */
    public int jump(int[] nums) {
        int length = nums.length;
        int[] step= new int[length];
        for (int i = 1; i < length; i++) {
            step[i] = Integer.MAX_VALUE;
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (i + nums[i] <= max) {
                // 减少无用对比
                continue;
            }
            for (int j = i +1; j < length && j <= i + nums[i]; j++) {
                step[j] = Math.min(step[j], step[i] + 1);
            }
            max = i + nums[i];
        }
        return step[length -1];
    }

    public static void main(String[] args) {
        Q45 q = new Q45();
        q.jump(new int[]{2,3,1,1,4,4,1,2,1,2,3});
    }
}
