package com.spring13269.leetcode.Q901_1000;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Q_994 description
 *
 * @author zengle.huang@hand-china.com  2020/3/4
 * @version 1.0
 */
public class Q_994 {
    /**
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     *
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     *
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        Map<Integer, Set<String>> map = new HashMap<>(3);
        int maxi = grid.length;
        int maxj = grid[0].length;
        for (int i = 0; i< maxi; i++) {
            for (int j = 0; j<maxj; j++) {
                Set<String> set = map.getOrDefault(grid[i][j], new HashSet<>(maxi));
                set.add(i+":"+j);
                map.put(grid[i][j], set);
            }
        }

        while (map.get(2).size() > 0) {
            Set<String> error = map.get(2);
            map.get(2).forEach(entry -> {

            });
        }

        return -1;
    }
}
