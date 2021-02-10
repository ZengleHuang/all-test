package com.spring13269.leetcode.Q0_100;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Q51
 *
 * @author : zengle.huang@hand-china.com 2020/9/4
 */
public class Q51 {
    /**
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * 上图为 8 皇后问题的一种解法。
     * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
     * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     *
     * 示例：
     * 输入：4
     * 输出：[
     *  [".Q..",  // 解法 1
     *   "...Q",
     *   "Q...",
     *   "..Q."],
     *
     *  ["..Q.",  // 解法 2
     *   "Q...",
     *   "...Q",
     *   ".Q.."]
     * ]
     * 解释: 4 皇后问题存在两个不同的解法。
     * 提示：
     * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
     */

    public List<List<String>> solveNQueens(int n) {
        if (n == 1) {
            return Collections.singletonList(Collections.singletonList("Q"));
        }
        if (n < 1 || n == 2 || n == 3) {
            return Collections.emptyList();
        }
        Map<Integer, Map<Integer, Integer>> result = new HashMap<Integer, Map<Integer, Integer>>();
        Map<Integer, Integer> childRes = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (childRes.size()>0) {
                    for (Map.Entry<Integer, Integer> entry : childRes.entrySet()) {
                        // 同一行 同一列
                        flag = flag || entry.getKey().equals(i) || entry.getValue().equals(j)
                                //  正斜 \ 方向
                                || ((entry.getValue() - entry.getKey()) == i-j)
                                //  反斜 / 方向
                                || ((entry.getValue() + entry.getKey()) == i+j);
                    }
                }
                if (flag) {
                    continue;
                } else {
                    childRes.put(i, j);
                    break;
                }
            }

        }
        return null;
    }

}
