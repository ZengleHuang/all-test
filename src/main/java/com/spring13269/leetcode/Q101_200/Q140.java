package com.spring13269.leetcode.Q101_200;

import java.util.*;

/**
 * Q140
 *
 * @author : zengle.huang@hand-china.com 2020/11/1
 */
public class Q140 {
    /**
     * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
     * 说明：
     * 分隔时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * 示例 1：
     * 输入:
     * s = "catsanddog"
     * wordDict = ["cat", "cats", "and", "sand", "dog"]
     * 输出:
     * [
     *   "cats and dog",
     *   "cat sand dog"
     * ]
     * 示例 2：
     * 输入:
     * s = "pineapplepenapple"
     * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
     * 输出:
     * [
     *   "pine apple pen apple",
     *   "pineapple pen apple",
     *   "pine applepen apple"
     * ]
     * 解释: 注意你可以重复使用字典中的单词。
     * 示例 3：
     * 输入:
     * s = "catsandog"
     * wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出:
     * []
     */
    private final static String SPACE = " ";
    List<String> result = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s.length() <1) {
            return result;
        }
        Map<Character, List<String>> dictMap = new HashMap<>(26);
        wordDict.forEach(v -> {
            Character c = v.charAt(0);
            List<String> cList = dictMap.getOrDefault(c, new ArrayList<>());
            cList.add(v);
            dictMap.put(c, cList);
        });
        if (!dictMap.containsKey(s.charAt(0))) {
            return result;
        }
        getWordList(dictMap, s, new StringBuilder());
        return result;
    }

    private void getWordList(Map<Character, List<String>> dictMap, String str, StringBuilder sb) {
        if (str == null || str.length() < 1) {
            return;
        }
        if (!dictMap.containsKey(str.charAt(0))) {
            return;
        }
        dictMap.get(str.charAt(0)).forEach(v -> {
            StringBuilder s = new StringBuilder(sb);
            if (v.equals(str)) {
                result.add(s.append(v).toString());
            } else if (str.length() > v.length()) {
                String sub = str.substring(0, v.length());
                if (sub.equals(v)) {
                    getWordList(dictMap, str.substring(v.length()), s.append(v).append(SPACE));
                }
            }
        });
    }

    public static void main(String[] args) {
        Q140 q = new Q140();
        q.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
    }

}
