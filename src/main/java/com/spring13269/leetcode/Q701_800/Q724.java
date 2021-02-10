package com.spring13269.leetcode.Q701_800;

/**
 * Q724
 *
 * @author : zengle.huang@hand-china.com 2021/1/28
 */
public class Q724 {
    /**
     * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
     * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     *  
     * 示例 1：
     * 输入：
     * nums = [1, 7, 3, 6, 5, 6]
     * 输出：3
     * 解释：
     * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
     * 同时, 3 也是第一个符合要求的中心索引。
     * 示例 2：
     * 输入：
     * nums = [1, 2, 3]
     * 输出：-1
     * 解释：
     * 数组中不存在满足此条件的中心索引。
     *
     * 说明：
     * nums 的长度范围为 [0, 10000]。
     * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
     */
    public int pivotIndex(int[] nums) {
        int count = 0;
        int length = nums.length;
        int l = 0, r = length -1;
        while (r - l > 2) {
            if (count > 0) {
                count-=nums[l];
                l++;
            } else {
                count+=nums[r];
                r--;
            }
        }
        if (r - l == 2) {
            return l + 1;
        } else if (r == l) {
            return l;
        }
        return -1;
    }
    public int pivotIndex2(int[] nums) {
        int result = -1;
        int length = nums.length;
        if (length == 0) {
            return -1;
        } else if (length == 1) {
            return 0;
        } else if (length == 2) {
            if (nums[0] == 0 && nums[1] == 0) {
                return 0;
            }
            return -1;
        } else if (length == 3) {
            if (nums[0] == 0 && nums[2] == 0) {
                return nums[1] == 0 ? 0 : 1;
            } else if (nums[0] == nums[2]) {
                return 1;
            }
            return -1;
        }
        int lc = nums[0], rc = nums[length - 1];
        int l = 0, r = length - 1;
        for (; l < r; ) {
            if (lc < rc) {
                l++;
                lc += nums[l];
            } else if (lc > rc) {
                r--;
                rc += nums[r];
            } else if (lc == rc) {
                if (r - l == 2) {
                    return l + 1;
                } else {
                    int f = r - 1;
                    for (; f > l; f--) {
                        if (nums[f] != 0) {
                            r = f;
                            rc += nums[r];
                            /*l++;
                            lc += nums[l];
                            r--;
                            rc += nums[r];*/
                            break;
                        }
                    }
                    f = l+1;
                    for (; f< r; f++) {
                        if (nums[f] != 0) {
                            l = f;
                            lc += nums[f];
                        }
                    }
                    if (f == r) {
                        return l;
                    }
                }
            }
        }
        return -1;
    }
}
