package com.spring13269.leetcode.Q1001_1100;

import java.util.Arrays;

/**
 * Q1052
 *
 * @author : zengle.huang@hand-china.com 2021/2/23
 */
public class Q1052 {
    /**
     * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
     * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
     * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
     * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
     *  
     * 示例：
     * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
     * 输出：16
     * 解释：
     * 书店老板在最后 3 分钟保持冷静。
     * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
     *  
     * 提示：
     * 1 <= X <= customers.length == grumpy.length <= 20000
     * 0 <= customers[i] <= 1000
     * 0 <= grumpy[i] <= 1
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int length = customers.length;
        if (length != grumpy.length) {
            return 0;
        }
        int[] countNoX = new int[length];
        int[] nextXCount = new int[length];
        int notAngCount = 0;
        int kCount = 0;
        for (int i = 0; i<X && i < length; i++) {
            kCount+=customers[i];
        }
        nextXCount[0] = kCount;
        if (grumpy[0] == 0 ) {
            notAngCount += customers[0];
            countNoX[0] = customers[0];
        }
        for (int i = 1; i < length; i++) {
            if (grumpy[i] == 0) {
                notAngCount += customers[i];
            }
            countNoX[i] = notAngCount;

            int nextX = nextXCount[i-1] - customers[i-1];
            if (i + X -1 < length) {
                nextX += customers[i+X-1];
            }
            nextXCount[i] = nextX;
        }
        System.out.println(Arrays.toString(grumpy));
        System.out.println(Arrays.toString(customers));
        System.out.println(Arrays.toString(countNoX));
        System.out.println(Arrays.toString(nextXCount));
        int max = kCount;
        max = notAngCount - countNoX[X - 1] + nextXCount[0];
        for (int i = 1; i < length; i++) {
            int x = notAngCount - (countNoX[i+X - 1 < length ? i+X -1 : length - 1] - countNoX[i -1]) + nextXCount[i];
            max = Math.max(max, x);
        }
        return max;
    }

    public static void main(String[] args) {
        Q1052 q = new Q1052();
        q.maxSatisfied(new int[]{1,0,1,2,1,1,7,5,4,4,4,4,1,2,2,1,3,1,3,1,1,2,3,1,2,4,5},
                new int[]{0,1,0,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1}, 6);
        //[1, 1, 2, 2, 3, 3, 10, 10]
        //[2, 3, 4, 4, 9, 13, 12, 5]
    }
}
