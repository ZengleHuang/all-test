package com.spring13269.leetcode.Q1101_1200;

import java.util.Arrays;

/**
 * Q1170 description
 *
 * @author zengle.huang@hand-china.com  2019/12/10
 * @version 1.0
 */
public class Q1170 {
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] compares = new int[11];
        for(int i = 0; i< words.length; i++) {
            compares[s(words[i])]++;
        }
        int[] results = new int[queries.length];
        for(int i =0; i<queries.length;i++) {
            int res = s(queries[i]);
            for(int j =10; j> res;j--) {
                results[i] += compares[j];
            }
        }
        return results;
    }

    public static int s(String str) {
        int count = 1;
        char c = str.charAt(0);
        for (int i = 1; i< str.length();i++) {
            char v = str.charAt(i);
            if (v < c) {
                count = 1;
                c = v;
            } else if (v== c) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //["bbb","cc","adffasddfhenaaa","ffffffadd"]
        //["a","aa","aaa","aaaa","ffasdfe","ffffffff"]
        String[] queries = new String[]{"bbb","cc","adffasddfhenaaa","ffffffadd"};
        String[] words = new String[]{"a","aa","aaa","aaaa","ffasdfe","ffffffff"};
        System.out.println(Arrays.toString(numSmallerByFrequency(queries, words)));
    }
}
