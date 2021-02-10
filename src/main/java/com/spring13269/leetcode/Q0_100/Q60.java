package com.spring13269.leetcode.Q0_100;

/**
 * Q60
 *
 * @author : zengle.huang@hand-china.com 2020/9/5
 */
public class Q60 {
    /**
     * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列。
     *
     * 说明：
     * 给定 n 的范围是 [1, 9]。
     * 给定 k 的范围是[1,  n!]。
     * 示例 1:
     * 输入: n = 3, k = 3
     * 输出: "213"
     * 示例 2:
     * 输入: n = 4, k = 9
     * 输出: "2314"
     *
     * 1234
     * 1243
     * 1324
     * 1342
     * 1423
     * 1432
     *
     * 2134
     * 2143
     * 2314
     * 2341
     * 2413
     * 2431
     */

    public static String getPermutation(int n, int k) {
        if (n < 1 || k <1) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        int used[] = new int[n+1];
        int jieche[] = new int[]{1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        StringBuilder result = new StringBuilder();
        for (int i = n-2; i>=0; i--) {
            int num = k/jieche[i];
            used[i] = 1;
            k = k%jieche[i];
            System.out.println(num);
            if (k == 0) {
                result.append(num);
                for (int j = 1; j <= n; j++) {
                    if (used[j] != 1) {
                        result.append(j);
                    }
                }
                return result.toString();
            }
            int cou = 0;
            for (int j = 1; j <= n; j++) {
                if (used[j] == 0) {
                    cou++;
                }
                if (cou == num+1) {
                    result.append(num + 1);
                    break;
                }
            }
        }
        /*--n;
        while (k % jieche[--n] != 0) {
            int num = k/jieche[n];
            System.out.println(num);
            result.append(num+1);
        }*/
        result.append(k/jieche[n]);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
    }

}
