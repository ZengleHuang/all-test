package com.spring13269.leetcode.Q201_300;

/**
 * Q201
 *
 * @author : zengle.huang@hand-china.com 2020/8/23
 */
public class Q201 {
    /**
     * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
     *
     * 示例 1: 
     * 输入: [5,7]
     * 输出: 4
     * 示例 2:
     * 输入: [0,1]
     * 输出: 0
     */

    public int rangeBitwiseAnd(int m, int n) {
        /*int i = 0;
        while (m >0) {
            i++;
            m = m>>1;
            n = n>>1;
            if (n == 0) {
                return 0;
            }
            if (n == m) {
                return m<<i;
            }
        }*/
        int offset = 0;
        while(m != n){
            m >>= 1;
            n >>= 1;
            offset++;
        }
        return m << offset;
    }
}
