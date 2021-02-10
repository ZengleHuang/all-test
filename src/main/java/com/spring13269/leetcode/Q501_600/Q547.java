package com.spring13269.leetcode.Q501_600;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Q547
 *
 * @author : zengle.huang@hand-china.com 2021/1/7
 */
public class Q547 {
    /**
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
     * 返回矩阵中 省份 的数量。
     * 示例 1：
     * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * 输出：2
     * 示例 2：
     * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
     * 输出：3
     *  
     * 提示：
     * 1 <= n <= 200
     * n == isConnected.length
     * n == isConnected[i].length
     * isConnected[i][j] 为 1 或 0
     * isConnected[i][i] == 1
     * isConnected[i][j] == isConnected[j][i]
     */
    public int findCircleNum2(int[][] isConnected) {
        /*Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) {
            resultSet.add(i);
        }
*/
        int[] result = new int[isConnected.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1) {
                    //resultSet.remove(j);
                    if (result[j] != -1) {
                        result[j] = -1;
                    } else {
                        result[i] = -1;
                    }
                }
            }
        }
        //return resultSet.size();
        Set<Integer> res = new HashSet<>();
        for (int i : result) {
            res.add(i);
        }
        res.remove(-1);
        return res.size();
    }

    public int findCircleNum(int[][] isConnected) {
        int[] result = new int[isConnected.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1) {
                    int resultk = result[j];
                    for (int k = 0; k < result.length; k++) {
                        if (result[k] == resultk) {
                            result[k] = result[i];
                        }
                    }
                }
            }
        }
        Set<Integer> res = new HashSet<>();
        for (int i : result) {
            res.add(i);
        }
        //(int) Arrays.stream(result).distinct().count();
        return res.size() == 0 ? 1 : res.size();
    }

    public static void main(String[] args) {
        Q547 q = new Q547();
        /*q.findCircleNum2(new int[][]{
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}});*/
        // 2,4,5,6,8,9,10,11,12,13,14
        q.findCircleNum2(new int[][]{
                {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                {0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},
                {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},
                {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                {0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}
        });
    }
    // [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
    // [[1,0,0,0,0,0,0,0,0,1,0,0,0,0,0],[0,1,0,1,0,0,0,0,0,0,0,0,0,1,0],[0,0,1,0,0,0,0,0,0,0,0,0,0,0,0],[0,1,0,1,0,0,0,1,0,0,0,1,0,0,0],[0,0,0,0,1,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,1,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,1,0,0,0,0,0,0,0,0],[0,0,0,1,0,0,0,1,1,0,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0,0,0],[1,0,0,0,0,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0,0,0],[0,0,0,1,0,0,0,0,0,0,0,1,0,0,0],[0,0,0,0,1,0,0,0,0,0,0,0,1,0,0],[0,1,0,0,0,0,0,0,0,0,0,0,0,1,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]]
    // [[1,1,1],[1,1,1],[1,1,1]]

}
