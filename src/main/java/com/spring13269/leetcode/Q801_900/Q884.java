package com.spring13269.leetcode.Q801_900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q884 description
 *
 * @author zengle.huang@hand-china.com  2019/12/27
 * @version 1.0
 */
public class Q884 {

    /**
     * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
     *
     * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
     *
     * 返回所有不常用单词的列表。
     */
    public String[] uncommonFromSentences2(String A, String B) {
        Map<String, Integer> resultMap = new HashMap<>(30);
        update(A, resultMap);
        update(B, resultMap);
        return resultMap.entrySet().stream().filter(entry -> 1 == entry.getValue())
                .map(Map.Entry::getKey).toArray(String[]::new);

    }
    private static final char space = ' ';
    private void update(String A, Map<String, Integer> resultMap) {
        StringBuilder sb = new StringBuilder();
        for (char c: A.toCharArray()) {
            if (space == c) {
                if (sb.length() == 0) {
                } else {
                    String str = sb.toString();
                    sb = new StringBuilder();
                    resultMap.put(str, resultMap.getOrDefault(str, 0) + 1);
                }
            } else {
                sb.append(c);
            }
        }
        String str = sb.toString();
        resultMap.put(str, resultMap.getOrDefault(str, 0) + 1);
    }


    public String[] uncommonFromSentences(String A, String B) {
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        Map<String, Integer> resultMap = new HashMap<>(a.length + b.length);
        for (String str: a) {
            resultMap.put(str, resultMap.getOrDefault(str, 0) + 1);
        }
        for (String str: b) {
            resultMap.put(str, resultMap.getOrDefault(str, 0) + 1);
        }
        return resultMap.entrySet().stream().filter(entry -> 1 == entry.getValue())
                .map(Map.Entry::getKey).toArray(String[]::new);

    }

}
