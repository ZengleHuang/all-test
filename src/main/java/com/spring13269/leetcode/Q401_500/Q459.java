package com.spring13269.leetcode.Q401_500;

import java.util.Objects;

/**
 * Q459
 *
 * @author : zengle.huang@hand-china.com 2020/8/24
 */
public class Q459 {
    /**
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     *
     * 示例 1:
     * 输入: "abab"
     * 输出: True
     * 解释: 可由子字符串 "ab" 重复两次构成。
     * 示例 2:
     * 输入: "aba"
     * 输出: False
     * 示例 3:
     *
     * 输入: "abcabcabcabc"
     * 输出: True
     * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
     */

    public boolean repeatedSubstringPattern(String s) {
        if (s.length() <= 1) {
            return false;
        }
        //char[] minS = new char[s.length()];
        char a = s.charAt(0);
        String minS = null;
        for (int i = 1; i< s.length()/2 + 1; i++) {
            if (Objects.equals(s.charAt(i), a)) {
                minS = s.substring(0, i);
            }
            if (minS != null) {
                // 整体字符串肯定是子串的整数倍
                if (s.length() % minS.length() != 0) {
                    minS = null;
                    continue;
                }
                boolean flag = true;
                for(int j = i; j < s.length() ; j+= minS.length()) {
                    String b = s.substring(j, j+minS.length());
                    if (!Objects.equals(minS, b)) {
                        minS = null;
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("最小子串是{}"+ minS);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "asdfasdfadsf";
        System.out.println(a.substring(0,1));
    }
}
