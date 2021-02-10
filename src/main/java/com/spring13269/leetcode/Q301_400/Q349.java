package com.spring13269.leetcode.Q301_400;

import java.util.*;

/**
 * Q349
 *
 * @author : zengle.huang@hand-china.com 2020/11/2
 */
public class Q349 {
    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 示例 1：
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     * 示例 2：
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     *
     * 说明：
     * 输出结果中的每个元素一定是唯一的。
     * 我们可以不考虑输出结果的顺序。
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        if (nums1.length < nums2.length) {
            Set<Integer> existSet = new HashSet<>(nums1.length);
            for (int i : nums1) {
                existSet.add(i);
            }
            Set<Integer> resultSet = new HashSet<>(existSet.size());
            for (int i : nums2) {
                if (existSet.contains(i)) {
                    resultSet.add(i);
                }
            }
            int[] result = new int[resultSet.size()];
            int index = 0;
            for (int num : resultSet) {
                result[index++] = num;
            }
            return result;
        } else {
            Set<Integer> existSet = new HashSet<>(nums2.length);
            for (int i : nums2) {
                existSet.add(i);
            }
            Set<Integer> resultSet = new HashSet<>(existSet.size());
            for (int i : nums1) {
                if (existSet.contains(i)) {
                    resultSet.add(i);
                }
            }
            int[] result = new int[resultSet.size()];
            int index = 0;
            for (int num : resultSet) {
                result[index++] = num;
            }
            return result;
        }
    }
}
