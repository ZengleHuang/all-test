package com.spring13269.leetcode.Q101_200;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Q200
 *
 * @author : zengle.huang@hand-china.com 2020/9/27
 */
public class Q200 {
    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     *  
     *
     * 示例 1:
     *
     * 输入:
     * [
     * ['1','1','1','1','0'],
     * ['1','1','0','1','0'],
     * ['1','1','0','0','0'],
     * ['0','0','0','0','0']
     * ]
     * 输出: 1
     * 示例 2:
     *
     * 输入:
     * [
     * ['1','1','0','0','0'],
     * ['1','1','0','0','0'],
     * ['0','0','1','0','0'],
     * ['0','0','0','1','1']
     * ]
     * 输出: 3
     * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
     */
    int[][] islandNum = null;
    int x = 0;
    int y = 0;
    public int numIslands(char[][] grid) {
        if (grid.length < 1) {
            return 0;
        }
        x = grid.length;
        y = grid[0].length;
        islandNum = new int[grid.length][grid[0].length];
        Map<Integer, List<Integer>> islandMap = new HashMap<>();
        for (int i = 0; i<x; i++) {
            for (int j = 0; j<y; j++) {
                if (grid[i][j] == 1) {
                    if (i > 0) {
                        if (islandNum[i-1][j] != 0) {

                        }
                    }
                    if (j > 0) {

                    }
                }
            }
        }
        return 0;

    }
}
