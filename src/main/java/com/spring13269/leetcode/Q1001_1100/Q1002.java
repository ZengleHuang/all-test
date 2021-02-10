package com.spring13269.leetcode.Q1001_1100;

import java.util.ArrayList;
import java.util.List;

/**
 * Q1002
 *
 * @author : zengle.huang@hand-china.com 2020/10/14
 */
public class Q1002 {
    /**
     * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
     * 你可以按任意顺序返回答案。
     *
     * 示例 1：
     * 输入：["bella","label","roller"]
     * 输出：["e","l","l"]
     * 示例 2：
     * 输入：["cool","lock","cook"]
     * 输出：["c","o"]
     *  
     * 提示：
     * 1 <= A.length <= 100
     * 1 <= A[i].length <= 100
     * A[i][j] 是小写字母
     */

    public List<String> commonChars(String[] A) {
        if (A.length < 1) {
            return new ArrayList<>();
        }
        int[] result = new int[26];
        for (int i = 0; i < result.length; i++) {
            result[i] = 100;
        }

        for (String s : A) {
            int[] word = new int[26];
            for (char c : s.toCharArray()) {
                word[c - 'a'] ++;
            }
            for (int i = 0; i < result.length; i++) {
                result[i] = Math.min(result[i], word[i]);
            }
        }

        List<String> v = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 0) {
                char word = (char) ('a'+i);
                for (int i1 = 0; i1 < result[i]; i1++) {
                    v.add(String.valueOf(word));
                }
            }
        }
        return v;

    }
}
