package com.spring13269.leetcode.Q101_200;

/**
 * Q189
 *
 * @author : zengle.huang@hand-china.com 2021/1/8
 */
public class Q189 {
    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 示例 1:
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     * 说明:
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k > length) {
            k = k%length;
        }
        if (k <= 0) {
            return;
        }
        reserve(nums, 0, length);
        reserve(nums, 0, k);
        reserve(nums, k + 1, length);



        /*int[] lastK = new int[k];
        for (int i = 0; i < k; i++) {
            lastK[i] = nums[length - 1 - i];
        }
        for (int i = 0; i < length - k; i++) {
            nums[length - i -1] = nums[length - k -1 -i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = lastK[k - i -1];
        }*/


        /*int last = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 1; i--) {
            nums[i] = nums[i -1];
        }
        nums[0] = last;
        rotate(nums, k -1);*/
    }

    public void reserve(int[] arr, int start, int end) {
        if (start >= end || end > arr.length) {
            return;
        }
        int point = (end - start + 1) /2;
        for (int i = 0; i < point; i ++) {
            int flag = arr[start + i];
            arr[start + i] = arr[end - i - 1];
            arr[end - i - 1] = flag;
        }
    }

    public static void main(String[] args) {
        Q189 q = new Q189();
        q.rotate(new int[]{-1,-100,3,99}, 1);
    }
}
