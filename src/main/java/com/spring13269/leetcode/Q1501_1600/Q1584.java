package com.spring13269.leetcode.Q1501_1600;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Q1584
 *
 * @author : zengle.huang@hand-china.com 2021/1/19
 */
public class Q1584 {
    /**
     * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
     * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
     * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
     *  
     * 示例 1：
     * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
     * 输出：20
     * 解释：
     * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
     * 注意到任意两个点之间只有唯一一条路径互相到达。
     * 示例 2：
     * 输入：points = [[3,12],[-2,5],[-4,1]]
     * 输出：18
     * 示例 3：
     * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
     * 输出：4
     * 示例 4：
     * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
     * 输出：4000000
     * 示例 5：
     * 输入：points = [[0,0]]
     * 输出：0
     * 提示：
     * 1 <= points.length <= 1000
     * -106 <= xi, yi <= 106
     * 所有点 (xi, yi) 两两不同。
     */
    public int minCostConnectPoints(int[][] points) {
        int size = points.length;
        if (size < 2) {
            return 0;
        }
        int[][] cost = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                int abs =  abs(points[i][0]-points[j][0]) + abs(points[i][1]-points[j][1]);
                cost[i][j] = abs;
                cost[j][i] = abs;
            }
            cost[i][i] = Integer.MAX_VALUE;
        }
        Arrays.stream(cost).forEach(v -> {
            Arrays.stream(v).forEach(k -> System.out.print(k + "\t"));
            System.out.println();
        });
        Set<Integer> added = new HashSet<>(size);
        added.add(0);
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            int numMin = Integer.MAX_VALUE;
            for (int j = 0; j < size; j++) {
                numMin = Math.min(cost[i][j], numMin);
            }
            /*for (int j = 0; j < size; j++) {
                numMin = Math.min(cost[j][i], numMin);
            }*/
            min = Math.min(min, numMin);
            result += numMin;
        }

        return result - min;
    }


    public int minCostConnectPoints_failed(int[][] points) {
        int size = points.length;
        if (size < 2) {
            return 0;
        }
        int[][] cost = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                int abs =  abs(points[i][0]-points[j][0]) + abs(points[i][1]-points[j][1]);
                cost[i][j] = abs;
                cost[j][i] = abs;
            }
            cost[i][i] = Integer.MAX_VALUE;
        }
        Arrays.stream(cost).forEach(v -> {
            Arrays.stream(v).forEach(k -> System.out.print(k + "\t"));
            System.out.println();
        });
        Set<Integer> added = new HashSet<>(size);
        added.add(0);
        int result = 0;
        while (added.size() < size) {
            int min = Integer.MAX_VALUE;
            int minX = 0;
            int minY = 0;
            for (Integer k : added) {

                //}
                //for (int k = 0; k < size; k++) {
                for (int m = 0; m < size; m++) {
                    if (added.contains(m)) {
                        continue;
                    }
                    if (cost[k][m] < min) {
                        minX = k;
                        minY = m;
                        min = cost[k][m];
                    }}
            }
            added.add(minY);
            result+= min;
            System.out.print(added);
            System.out.println( "   minY " + minY + "   minX " + minX + "   result " + result);
        }
        return result;
    }

    private int abs(int val) {
        return val >= 0 ? val : -val;
    }

    public static void main(String[] args) {
        Q1584 q = new Q1584();
        System.out.println(q.minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}})); // 20
        System.out.println(q.minCostConnectPoints(new int[][]{{0,0},{1,1},{1,0},{-1,1}})); // 4
        System.out.println(q.minCostConnectPoints(new int[][]{{0,0},{1,1},{1000,1000},{1001,1000}}));
        System.out.println(q.minCostConnectPoints(new int[][]{{3,12},{-2,5},{-4,1}}));
        System.out.println(q.minCostConnectPoints(new int[][]{{2,-3},{-17,-8},{13,8},{-17,-15}})); // 53
    }
}
