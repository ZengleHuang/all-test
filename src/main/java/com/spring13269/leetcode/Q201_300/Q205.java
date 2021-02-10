package com.spring13269.leetcode.Q201_300;

/**
 * Q205
 *
 * @author : zengle.huang@hand-china.com 2020/12/29
 */
public class Q205 {
    /**
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     *
     * 示例 1:
     * 输入: s = "egg", t = "add"
     * 输出: true
     * 示例 2:
     * 输入: s = "foo", t = "bar"
     * 输出: false
     * 示例 3:
     * 输入: s = "paper", t = "title"
     * 输出: true
     * 说明:
     * 你可以假设 s 和 t 具有相同的长度。
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] key = new int[200];
        int[] valueSet = new int[200];
        for (int i = 0; i < key.length; i++) {
            key[i] = -1;
            valueSet[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char tc = t.charAt(i);
            int v = (int)c;
            int tv = (int)tc;
            if (key[v] != -1 && key[v] != tv) {
                return false;
            }
            if (valueSet[tv] != -1 && valueSet[tv] != v) {
                return false;
            }
            key[v] = tv;
            valueSet[tv] = v;
        }
        return true;
    }

    public static void main(String[] args) {
        Q205 q = new Q205();
        q.isIsomorphic("addddfe","abbbbbb");
    }
}
