package com.spring13269.leetcode.Q1001_1100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Q1046 description
 *
 * @author zengle.huang@hand-china.com  2019/12/10
 * @version 1.0
 */
public class Q1046 {
    public static int lastStoneWeight(int[] stones) {
        if(stones.length == 1) {
            return stones[0];
        }
        int[] copys = new int[1001];
        for (int i=0;i<stones.length;i++) {
            copys[stones[i]]++;
        }
        int max1 = 0;
        for (int i = 1000;i>0;i--) {
            if(copys[i]>0) {
                copys[i]--;
                if (max1 == 0) {
                    max1 = i;
                    i++;
                } else {
                    copys[max1 - i]++;
                    i = Math.max(i, max1-i) + 1;
                    max1 = 0;
                }
            }
        }
        return max1;
    }


    public static int lastStoneWeight2(int[] stones) {
        if(stones.length == 1) {
            return stones[0];
        }
        int length = stones.length;
        while (length >= 2) {
            Arrays.sort(stones);
            int max1 = stones[length-1];
            int max2 = stones[length-2];
            stones = Arrays.copyOfRange(stones, 0, length-1);
            stones[length-2] = max1 - max2;
            length--;
        }
        return stones[0];
    }

    public static void main(String[] args) {
        int[]  stones=  new int[]{2,7,4,1,8,1};
        System.out.println(lastStoneWeight2(stones));
    }
}
