package com.spring13269.leetcode.Q501_600;

import java.util.Arrays;

/**
 * Q567
 *
 * @author : zengle.huang@hand-china.com 2021/2/10
 */
public class Q567 {
    /**
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     *
     * 示例1:
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     * 示例2:
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     *  
     * 注意：
     * 输入的字符串只包含小写字母
     * 两个字符串的长度都在 [1, 10,000] 之间
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() >  s2.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (char c : s1.toCharArray()) {
            arr[c-'a']++;
        }
        int[] curr = new int[26];
        int count = 0;
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            int f = c - 'a';
            if (arr[f] < 1) {
                // 重置
                curr = new int[26];
                count=0;
                continue;
            }
            curr[f]++;
            count++;
            if (count == s1.length()) {
                boolean equal = true;
                for (int j = 0; j < curr.length; j++) {
                    if (curr[j] != arr[j]) {
                        equal = false;
                        break;
                    }
                }
                if (equal) {
                    return true;
                } else {
                    count--;
                    // 获取首位
                    char first = s2.charAt(i - count);
                    curr[first - 'a']--;
                    continue;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q567 q = new Q567();
        q.checkInclusion("abcoo", "eidaabaooco");
    }
}
