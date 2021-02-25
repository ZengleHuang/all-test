package com.spring13269.leetcode.Q1001_1100;

import java.util.Arrays;

/**
 * Q1004
 *
 * @author : zengle.huang@hand-china.com 2021/2/19
 */
public class Q1004 {
    /**
     * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
     * 返回仅包含 1 的最长（连续）子数组的长度。
     *  
     * 示例 1：
     * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
     * 输出：6
     * 解释：
     * [1,1,1,0,0,1,1,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
     * 示例 2：
     * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
     * 输出：10
     * 解释：
     * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
     *
     * 提示：
     * 1 <= A.length <= 20000
     * 0 <= K <= A.length
     * A[i] 为 0 或 1 
     */
    public int longestOnes(int[] A, int K) {
        int i = 0;
        int length = A.length;
        int[] lengths = new int[length];
        while (K>0 && i< length){
            if (A[i] == 0) {
                K--;
            }
            i++;
        }
        if (K > 0) {
            return length;
        }
        int start = 0;
        lengths[0] = i-start;
        while (i < length) {
            lengths[start] = i - start;
            if (A[i] == 1) {
                i++;
                continue;
            } else {
                if (A[start] == 0) {
                    i++;
                }
                start++;
            }
        }
        if (start < length) {
            lengths[start] = i - start;
        }
        System.out.println(Arrays.toString(lengths));
        int max = 0;
        for (int j = 0; j < length; j++) {
            max = Math.max(lengths[j], max);
        }
        return max;
    }
    public int longestOnes1(int[] A, int K) {
        int totalOne = 0;
        int length = A.length;
        for (int i : A) {
            if (i == 1) {
                totalOne++;
            }
        }
        if (K >= length - totalOne) {
            return length;
        }
        int[] lengths = new int[length];
        for (int i = 0; i < length - K; i++) {
            int j = K;
            int k = i;
            while (j > 0 && k<length) {
                if (A[k] == 0) {
                    j--;
                }
                k++;
            }
            while (k <length && A[k] == 1) {
                k++;
            }
            lengths[i] = k - i;
        }
        System.out.println(Arrays.toString(lengths));
        int max = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(lengths[i], max);
        }
        return max;
    }
    public static void main(String[] args) {
        Q1004 q = new Q1004();
        //q.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
        q.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1}, 0);
    }
}
