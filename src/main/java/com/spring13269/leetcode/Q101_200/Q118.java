package com.spring13269.leetcode.Q101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Q118
 *
 * @author : zengle.huang@hand-china.com 2020/12/25
 */
public class Q118 {
    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * 示例:
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1],
     * [1,5,10,10,5,1],
     *[1,6,15,20,15,6,1],
     * ]
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>(1);
        } else if (numRows == 1) {
            return Collections.singletonList(Collections.singletonList(1));
        }
        List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(Collections.singletonList(1));
        for (int i = 2; i <= numRows; i++) {
            List<Integer> current = new ArrayList<>(i);
            List<Integer> last = result.get(i-1);
            current.add(1);
            for (int j = 1; j < i -1; j++) {
                current.add(last.get(j - 1) + last.get(j));
            }
            current.add(1);
            result.add(current);
        }
        return result;
    }
}
