package com.spring13269.leetcode.Q0_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Q78
 *
 * @author : zengle.huang@hand-china.com 2020/9/20
 */
public class Q78 {
    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * 说明：解集不能包含重复的子集。
     *
     * 示例:
     *
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        int v = 1 << length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            List<Integer> chi = new ArrayList<>();
            for (int j = 0; j <length; j++) {
                if ((i & (1 << j)) != 0) {
                    chi.add(nums[j]);
                }
            }
            result.add(chi);
        }
        return result;
    }
}
