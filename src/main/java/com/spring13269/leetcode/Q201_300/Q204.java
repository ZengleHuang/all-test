package com.spring13269.leetcode.Q201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * Q204
 *
 * @author : zengle.huang@hand-china.com 2020/12/3
 */
public class Q204 {
    /**
     * 统计所有小于非负整数 n 的质数的数量。
     * 示例 1：
     * 输入：n = 10
     * 输出：4
     * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     * 示例 2：
     * 输入：n = 0
     * 输出：0
     * 示例 3：
     * 输入：n = 1
     * 输出：0
     * 提示：
     * 0 <= n <= 5 * 106
     */
    int[] zhishu = new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499};
    List<Integer> zhiList;
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int result = 0;
        if (n < 500) {
            for (int i = 0; i < zhishu.length && zhishu[i] < n; i++) {
                result++;
            }
            return result;
        } else {
            zhiList = new ArrayList<>(n/3);
            for (int i : zhishu) {
                zhiList.add(i);
            }
            result = zhishu.length;
            for (int i = 500; i < n; i++) {
                if (isZhi(i)) {
                    result++;
                }
            }
            return result;

        }
    }

    public boolean isZhi(int num) {
        if (num > 500 && zhiList!= null) {
            //int half = Math.;
            Double.valueOf(Math.sqrt(num)).intValue();
            if (num %6!= 1&&num %6!= 5) {
                return false;
            } else {
                return true;
            }
            /*for (Integer integer : zhiList) {
                //if (num%integer == 0) {
                if (num %6!= 1&&num %6!= 5) {
                    return false;
                } else if (integer*integer > num) {
                    zhiList.add(num);
                    return true;
                }
            }*/
        }
        if (num %2 == 0) {
            return false;
        }
        for (int i = 2; i < num/2; i++) {
            if (num%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q204 q = new Q204();
        for (int i = 1; i < 500; i++) {
            if (q.isZhi(i)) {
                System.out.print(i);
                System.out.print(",");
            }
        }
    }
}
