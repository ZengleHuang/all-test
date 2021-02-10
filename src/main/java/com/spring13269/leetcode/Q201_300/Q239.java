package com.spring13269.leetcode.Q201_300;

/**
 * Q239
 *
 * @author : zengle.huang@hand-china.com 2021/1/5
 */
public class Q239 {
    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回滑动窗口中的最大值。
     *
     * 示例 1：
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     * 示例 2：
     * 输入：nums = [1], k = 1
     * 输出：[1]
     * 示例 3：
     * 输入：nums = [1,-1], k = 1
     * 输出：[1,-1]
     * 示例 4：
     * 输入：nums = [9,11], k = 2
     * 输出：[11]
     * 示例 5：
     * 输入：nums = [4,-2], k = 2
     * 输出：[4]
     *
     * 提示：
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 1) {
            return nums;
        }
        int length = nums.length;
        int[] result = new int[length - k + 1];
        int startMax = findMaxInList(nums, 0, k);
        result[0] = nums[startMax];
        for (int i = 1; i < nums.length - k + 1; i++) {
            if (nums[i+k-1] >= nums[startMax]) {
                startMax = i+k-1;
            }
            if (startMax < i) {
                startMax = findMaxInList(nums, i, i+k);
            }
            result[i] = nums[startMax];
        }
        return result;
    }

    public int findMaxInList(int[] nums, int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i < Math.min(nums.length, end); i++) {
            if (nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Q239 q = new Q239();
        //q.maxSlidingWindow(new int[]{1,2,3,4,5,6,7,8,9}, 3);
        q.maxSlidingWindow(new int[]{9,11}, 2);
    }
}
