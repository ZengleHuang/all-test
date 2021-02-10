package com.spring13269.leetcode.Q801_900;

import java.util.HashSet;
import java.util.Set;

/**
 * ConsecutiveNumbersSum829 description
 *
 * @author zengle.huang@hand-china.com  2019/11/25
 * @version 1.0
 */
public class ConsecutiveNumbersSum829 {
    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(36152851));
        return;
    }

    public static int consecutiveNumbersSum1(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        int result = 0;
        for (int i = 1; i <= (N-1)/2;) {
            int sum = i;
            for (int j=i+1; j<= (N+1)/2 + 1; j++) {
                sum += j;
                if (sum == N) {
                    result++;
                    System.out.println("i " + i + "   j  " + j);
                    i++;
                    break;
                } else if (sum > i && sum < N) {
                } else {
                    // 从求和列表头开始减
                    i++;
                    break;
                }
            }
        }
        // 数据自身也算一个
        result++;
        return result;

    }





    public static int consecutiveNumbersSum(int N) {
        int result = 0;
        // 找奇数
        if (N == 1 || N == 2) {
            return 1;
        }
        int half = (N + 1)/2;
        int doubleN = 2 * N;
        Set<Integer> size = new HashSet<>();
        for (int i = 1; i <= half ; i++) {
            int n1 = (doubleN/i + i -1)/2;
            if (doubleN % i == 0 && (doubleN/i + i -1)%2 ==0) {
                size.add(n1);
                result ++;
            }
        }
        return size.size();
    }
}
