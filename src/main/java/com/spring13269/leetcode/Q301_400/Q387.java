package com.spring13269.leetcode.Q301_400;

import java.util.List;
import java.util.Set;

/**
 * Q387
 *
 * @author : zengle.huang@hand-china.com 2020/12/23
 */
public class Q387 {
    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     * 示例：
     * s = "leetcode"
     * 返回 0
     * s = "loveleetcode"
     * 返回 2
     *  
     * 提示：你可以假定该字符串只包含小写字母。
     */
    public int firstUniqChar(String s) {
        int[] minPoint = new int[26];
        int[] cCount = new int[26];
        int length = s.length();
        for (int i = 0; i < minPoint.length; i++) {
            minPoint[i] = length;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int position = c - 'a';
            if (minPoint[position] == length) {
                minPoint[position] = i;
            }
            cCount[position] ++;
        }
        int result = -1;
        for (int i = 0; i < cCount.length; i++) {
            if (cCount[i] == 1) {
                if (result == -1 || minPoint[i] < result) {
                    result = minPoint[i];
                }
            }
        }
        return result;
    }
}
