package com.spring13269.leetcode.Q0_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q77
 *
 * @author : zengle.huang@hand-china.com 2020/9/8
 */
public class Q77 {
    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     *
     * 示例:
     *
     * 输入: n = 4, k = 2
     * 输出:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     */
    public static List<List<Integer>> combine(int n, int k) {
        if (n<k) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        int all = n;
        int nbit = 1 << all;
        for (int i = 0; i < nbit; i++) {
            //StringBuffer sb = new StringBuffer();
            List<Integer> chi = new ArrayList<>(n);
            int jbit = 1 << all;
            boolean flag = false;
            for (int j = 0; j <= all; j++) {
                if (!flag && (i & (1 << j)) != 0) {
                    chi.add(j+1);
                    if (chi.size()>k) {
                        flag = true;
                    }
                    //sb.append(j+1);
                }
            }
            if (!flag && chi.size() == k) {
                System.out.println(Arrays.toString(chi.toArray()));
                result.add(chi);
            }
        }
        return result;
    }

    public static List<List<Integer>> combine11(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i<k; i++) {
            nums[i] = 1;
        }
        List<Integer> origin = new ArrayList<>(k);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            origin.add(i+1);
        }
        for (int i = 0; i < n-k+1;i++) {
            for (int j = i+k; j>i; j--) {
                List<Integer> newR = new ArrayList<>(origin);
                System.out.println(Arrays.toString(newR.toArray()));
                result.add(newR);
                newR.set(j-i-1, j+1);
                origin = newR;
            }
        }
        return result;
    }

    public static void main(String[] args){
        combine(6, 5);
    }
}
