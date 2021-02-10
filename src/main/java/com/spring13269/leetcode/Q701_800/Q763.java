package com.spring13269.leetcode.Q701_800;

import java.util.ArrayList;
import java.util.List;

/**
 * Q763 description
 *
 * @author zengle.huang@hand-china.com  2019/12/17
 * @version 1.0
 */
public class Q763 {
    /**
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
     * 返回一个表示每个字符串片段的长度的列表。
     */

    public List<Integer> partitionLabels(String S) {
        int[] maxV = new int[26];
        int[] minV = new int[26];
        for(int i = 0; i<minV.length; i++) {
            minV[i] = S.length();
        }
        int[] resultValues = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            int step = S.charAt(i) - 'a';
            if (maxV[step] < i) {
                maxV[step] = i;
            }
            if (minV[step] > i) {
                minV[step] = i;
            }
            resultValues[i] = step;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i< S.length(); i++) {
            if (maxV[resultValues[i-1]] > i) {

            }
        }
        return null;
    }

    int countResult(List<Integer> result) {
        return result.stream().reduce(0, Integer::sum);
    }
}
