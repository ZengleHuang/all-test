package com.spring13269.leetcode.Q201_300;

import java.util.Stack;

/**
 * Q214
 *
 * @author : zengle.huang@hand-china.com 2020/8/29
 */
public class Q214 {
    /**
     * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
     *
     * 示例 1:
     *
     * 输入: "aacecaaa"
     * 输出: "aaacecaaa"
     * 示例 2:
     *
     * 输入: "abcd"
     * 输出: "dcbabcd"
     */

    public static String shortestPalindrome(String s) {
        int len = s.length();
        if (len <2) {
            return s;
        }
        if (len==2) {
            if (s.charAt(0) ==  s.charAt(1)){
                return s;
            }
            return String.valueOf(s.charAt(1)).concat(s);
        }
        StringBuilder sb = new StringBuilder(s).reverse();
        for (int i = 0; i<sb.length(); i++) {
            if (sb.substring(i).equals(s.substring(0, len-i))) {
                return sb.substring(0,i).concat(s);
            }
        }
        return s;
/*
        for (Character c : s.toCharArray()) {

        }

        StringBuilder addSb = new StringBuilder();
        int i = len/2;

        for (; i< len ; i++) {
            int j = i+1;
            int k = 0;
            // 如果从j 位开始 每个都等于之前扣减的数据
            while (j+k < len && s.charAt(j+k) ==s.charAt(i-k)) {
                k ++;

            }
        }


        return s;*/
    }
    /*public String shortestPalindrome(String s) {
        if (s.length() <2) {
            return s;
        }
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i< len ; i++) {
            char c = s.charAt(i);
            if (i<(len/2)) {
                stack.push(c);
                continue;
            }
            // 如果栈中数据匹配， 进行回文检测
            int j = i;
            StringBuilder addSb = new StringBuilder();
            Stack<Character> addStr = new Stack<>();
            while (!stack.isEmpty()&& j < len) {
                Character top = stack.peek();
                // 如果栈中不匹配
                if (!top.equals(s.charAt(j))) {
                    stack.push(c);
                    break;
                }
                Character stackCur = stack.pop();
                j++;
                // 原串不是回文串
                if (j == len) {
                    addSb.append(s.charAt(j--));
                    addSb.append(stackCur);
                }
            }
            // 原串本身就是一个回文串
            if (j==len && stack.isEmpty()) {
                return s;
            }
        }
        return s;
    }*/

    public static int[] getNextArray(String destStr) {
        int[] nextArr = new int[destStr.length()];
        nextArr[0] = -1;
        int k = -1, j = 0;
        while (j < destStr.length() - 1) {
            if (k == -1 || (destStr.charAt(j) == destStr.charAt(k))) {
                ++k;
                ++j;
                nextArr[j] = k;
            } else {
                k = nextArr[k];
            }
        }
        return nextArr;
    }

    public static void main(String[] args) {
        //shortestPalindrome("abcde");
        getNextArray("aabaac");
    }
}
