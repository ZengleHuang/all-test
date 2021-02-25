package com.spring13269.leetcode.Q101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * Q119
 *
 * @author : zengle.huang@hand-china.com 2021/2/18
 */
public class Q119 {
    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * 示例:
     * 输入: 3
     * 输出: [1,3,3,1]
     * 进阶：
     * 你可以优化你的算法到 O(k) 空间复杂度吗？
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex);
        if (rowIndex == 0) {
            result.add(1);
            return result;
        }
        if (rowIndex == 1) {
            result.add(1);
            result.add(1);
            return result;
        }
        long num = 1;
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            num = num*(rowIndex-i+1)/i;
            result.add(Math.toIntExact(num));
            /*bc *= (rowIndex-i+1);
            c *= i;
            result.add(Math.toIntExact(bc / c));*/
        }
        return result;
    }

    public static void main(String[] args) {
        Q119 q = new Q119();
        q.getRow(3);
    }
}
