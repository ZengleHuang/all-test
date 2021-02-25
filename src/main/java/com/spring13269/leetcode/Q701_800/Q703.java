package com.spring13269.leetcode.Q701_800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q703
 *
 * @author : zengle.huang@hand-china.com 2021/2/18
 */
public class Q703 {
    /**
     * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
     * 请实现 KthLargest 类：
     * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
     * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
     *  
     * 示例：
     * 输入：
     * ["KthLargest", "add", "add", "add", "add", "add"]
     * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
     * 输出：
     * [null, 4, 5, 5, 8, 8]
     * 解释：
     * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
     * kthLargest.add(3);   // return 4
     * kthLargest.add(5);   // return 5
     * kthLargest.add(10);  // return 5
     * kthLargest.add(9);   // return 8
     * kthLargest.add(4);   // return 8
     *  
     * 提示：
     * 1 <= k <= 104
     * 0 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * -104 <= val <= 104
     * 最多调用 add 方法 104 次
     * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
     */
    public static void main(String[] args) {

    }

    class KthLargest {
        int[] maxK;
        int k;

        public KthLargest(int k, int[] nums) {
            maxK = new int[k];
            this.k = k;
            if (k <= nums.length) {
                Arrays.sort(nums);
                maxK = Arrays.copyOfRange(nums, nums.length - k, nums.length);
            } else{
                maxK[0] = Integer.MIN_VALUE;
                for (int i = 0; i < nums.length; i++) {
                    maxK[i+1] = nums[i];
                }

            }
        }

        public int add(int val) {
            if (val > maxK[0]) {
                int i = 0;
                boolean isB = false;
                for (; i < k -1 && val > maxK[i]; i++) {
                    maxK[i] = maxK[i+1];
                }
                if (val > maxK[i]) {
                    maxK[i] = val;
                } else {
                    maxK[i-1] = val;
                }
                System.out.println(Arrays.toString(maxK));
            }
            return maxK[0];
        }
    }
}
