package com.spring13269.leetcode.Q801_900;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Q824 description
 *
 * @author zengle.huang@hand-china.com  2019/12/6
 * @version 1.0
 */
public class Q824 {
    /***
     * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
     *
     * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
     *
     * 山羊拉丁文的规则如下：
     *
     * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
     * 例如，单词"apple"变为"applema"。
     *
     * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
     * 例如，单词"goat"变为"oatgma"。
     *
     * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
     * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
     * 返回将 S 转换为山羊拉丁文后的句子。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/goat-latin
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param S
     * @return
     */
    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder("");
        StringBuilder word = new StringBuilder("");
        List<Character> matchs = Arrays.asList('A','E','I','O','U','a','e','i','o','u');
        boolean wordStart = true;
        Character firstChar = null;
        int index = 1;
        for (int i = 0; i < S.length(); i++) {
            if (Objects.equals(S.charAt(i),' ')) {
                if (firstChar!=null) {
                    word.append(firstChar);
                }
                word.append("ma");
                for (int j=0; j<index; j++) {
                    word.append('a');
                }
                word.append(S.charAt(i));
                sb.append(word.toString());

                wordStart = true;
                word = new StringBuilder("");
                firstChar = null;
                index++;
            } else if (wordStart) {
                wordStart = false;
                if (matchs.contains(S.charAt(i))) {
                    word.append(S.charAt(i));
                } else {
                    firstChar = S.charAt(i);
                }
            } else {
                word.append(S.charAt(i));
            }
        }

        if (firstChar!=null) {
            word.append(firstChar);
        }
        word.append("ma");
        for (int j=0; j<index; j++) {
            word.append('a');
        }
        sb.append(word.toString());
        return sb.toString();
    }
}
