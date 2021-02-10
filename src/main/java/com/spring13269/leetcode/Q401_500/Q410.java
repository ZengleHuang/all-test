package com.spring13269.leetcode.Q401_500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Q410
 *
 * @author : zengle.huang@hand-china.com 2020/7/26
 */
public class Q410 {

    /**
     * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
     *
     * 注意:
     * 数组长度 n 满足以下条件:
     *
     * 1 ≤ n ≤ 1000
     * 1 ≤ m ≤ min(50, n)
     * 示例:
     *
     * 输入:
     * nums = [7,2,5,10,8]
     * m = 2
     *
     * 输出:
     * 18
     *
     * 解释:
     * 一共有四种方法将nums分割为2个子数组。
     * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
     * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
     *
     */
    public int splitArray(int[] nums, int m) {
        if (nums.length <= 0) {
            return 0;
        }
        if (m <= 0) {
            return 0;
        }
        if (nums.length <= m) {
            return Arrays.stream(nums).max().orElse(0);
        }
        int[][] sums = new int[nums.length - m][m];
        for (int i = 0; i< sums.length; i++) {
            for (int j = 0; j< m; j++) {

            }
        }
        return 1;
    }

    public int lineMin(int start, int[] nums, int m) {
        if (start > nums.length) {
            return -1;
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = start; i < nums.length; i++) {

        }
        return 0;
    }
}
