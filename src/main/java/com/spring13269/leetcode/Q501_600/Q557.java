package com.spring13269.leetcode.Q501_600;

import java.util.Stack;

/**
 * Q557
 *
 * @author : zengle.huang@hand-china.com 2020/8/30
 */
public class Q557 {
    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     * 示例：
     * 输入："Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     *  
     * 提示：
     * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     */

    public static String reverseWords(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int last = 0;
        StringBuilder lastStr;
        String[] spliters = s.split(" ");
        for (String spliter : spliters) {
            if (spliter.length() < 2) {
                sb.append(spliter);
            } else {
                sb.append(new StringBuilder(spliter).reverse());
            }
            sb.append(" ");
        }
        /*for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (last < i) {
                    System.out.println("");
                    lastStr = new StringBuilder(s.substring(last, i));
                    last = i+1;
                    sb.append(lastStr.reverse());
                    sb.append(' ');
                }
                *//*while (!st.isEmpty()) {
                    sb.append(st.pop());
                }*//*
            } else {
                *//*lastStr = s.substring()
                st.push(c);
                s.substring()*//*

            }
        }*/
        /*while (!st.isEmpty()) {
            sb.append(st.pop());
        }*/
        /*if (last < s.length()) {
            lastStr = new StringBuilder(s.substring(last));
            sb.append(lastStr.reverse());
        }
        s.split("");*/
        //sb.reverse()
        return sb.toString().trim();


    }

    public static void main(String[] args) {
        reverseWords("a b b c c d d w");
    }
}
