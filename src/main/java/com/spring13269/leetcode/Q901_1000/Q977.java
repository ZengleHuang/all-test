package com.spring13269.leetcode.Q901_1000;

import java.util.Arrays;

/**
 * Q977
 *
 * @author : zengle.huang@hand-china.com 2020/10/16
 */
public class Q977 {
    /**
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     *
     * 示例 1：
     * 输入：[-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 示例 2：
     * 输入：[-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     *  
     *
     * 提示：
     * 1 <= A.length <= 10000
     * -10000 <= A[i] <= 10000
     * A 已按非递减顺序排序。
     */
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int minAbs = Math.abs(A[0]);
        int minAbsV = 0;
        if (A[0] < 0) {
            for (int i = 1; i < A.length; i++) {
                if (minAbs >= Math.abs(A[i])) {
                    minAbs = Math.abs(A[i]);
                    minAbsV = i;
                } else {
                    break;
                }
            }
        }
        result[0] = minAbs * minAbs;
        for (int k =1, i=minAbsV-1, j=minAbsV+1; (i>=0 || j <= A.length) && k < A.length;) {
            if (i < 0) {
                result[k] = A[j]*A[j];
                j++;
            } else if (j > A.length-1) {
                result[k] = A[i]*A[i];
                i--;
            } else if (Math.abs(A[i]) < Math.abs(A[j])) {
                result[k] = A[i]*A[i];
                i--;
            } else {
                result[k] = A[j]*A[j];
                j++;
            }
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        Q977 q = new Q977();
        int[] res = q.sortedSquares(new int[]{-3,-3,-2,1,3,4});
        System.out.println(Arrays.toString(res));
    }
}
