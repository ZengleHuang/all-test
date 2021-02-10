package com.spring13269.leetcode.Q201_300;

/**
 * Q283
 *
 * @author : zengle.huang@hand-china.com 2020/11/19
 */
public class Q283 {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        //int str=0, end = nums.length-1;
        int countZ = 0;
        for (int str = 0; str < nums.length; str++) {
            if (nums[str] == 0) {
                countZ++;
            } else if (countZ > 0) {
                /*nums[str] = nums[end];
                nums[end] = 0;
                end--;*/
                nums[str-countZ] = nums[str];
                nums[str]=0;
            }
        }

    }
    public static void main(String[] args) {
        Q283 q = new Q283();
        q.moveZeroes(new int[]{0,1,0,2,3,4,0,0,1});
    }
}
