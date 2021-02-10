package com.spring13269.leetcode.Q201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * Q290
 *
 * @author : zengle.huang@hand-china.com 2020/12/30
 */
public class Q290 {
    /**
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     *
     * 示例1:
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     * 示例 2:
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     * 示例 3:
     * 输入: pattern = "aaaa", str = "dog cat cat dog"
     * 输出: false
     * 示例 4:
     * 输入: pattern = "abba", str = "dog dog dog dog"
     * 输出: false
     * 说明:
     * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
     */
    public boolean wordPattern(String pattern, String s) {
        char[] patternChr = pattern.toCharArray();
        String[] sSplit = s.split(" ");
        if (patternChr.length != sSplit.length) {
            return false;
        }
        Map<Character, String> patterMap = new HashMap<>(pattern.length());
        Map<String, Character> strPatterMap = new HashMap<>(pattern.length());
        for (int i = 0; i < patternChr.length; i++) {
            if (patterMap.containsKey(patternChr[i])) {
                if (!patterMap.get(patternChr[i]).equals(sSplit[i])) {
                    return false;
                }
            } else {
                patterMap.put(patternChr[i], sSplit[i]);
            }
            if (strPatterMap.containsKey(sSplit[i])) {
                if (!strPatterMap.get(sSplit[i]).equals(patternChr[i])) {
                    return false;
                }
            } else {
                strPatterMap.put(sSplit[i], patternChr[i]);
            }
        }
        return true;
    }
}
