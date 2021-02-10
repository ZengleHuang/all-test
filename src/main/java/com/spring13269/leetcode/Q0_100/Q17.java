package com.spring13269.leetcode.Q0_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Q17
 *
 * @author : zengle.huang@hand-china.com 2020/8/26
 */
public class Q17 {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * 9键 转字母
     * <p>
     * 示例:
     * <p>
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     */
    static final String[] vMap = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private static class NumNode {
        int num;

        public NumNode(char c) {
            this.num = c - '0';
        }

        public NumNode(int num) {
            this.num = num;
        }

        public List<StringBuilder> getWithCurrentNum(StringBuilder oStr) {
            String chars = vMap[num];
            return Stream.of(chars.split("")).map(cha -> new StringBuilder(oStr).append(cha)).collect(Collectors.toList());
        }
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() < 1) {
            return new ArrayList<>();
        }
        Vector<StringBuilder> result = new Vector<>(digits.length() * 4);
        result.add(new StringBuilder(""));
        for (char num : digits.toCharArray()) {
            switch (num) {
                case '0':
                case '1':
                    return new ArrayList<>();
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    result = result.parallelStream()
                            .flatMap(re -> new NumNode(num).getWithCurrentNum(re).stream()).distinct()
                            .collect(Collectors.toCollection(Vector::new));
                    System.out.println(Arrays.toString(result.toArray()));
                    break;
                default:
                    throw new RuntimeException();
            }
        }
        return result.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        letterCombinations("13");
    }
}
