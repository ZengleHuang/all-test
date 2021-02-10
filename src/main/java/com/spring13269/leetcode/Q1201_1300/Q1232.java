package com.spring13269.leetcode.Q1201_1300;

import com.spring13269.leetcode.Q1301_1400.Q1323;

/**
 * Q1232
 *
 * @author : zengle.huang@hand-china.com 2021/1/17
 */
public class Q1232 {
    /**
     * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
     * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
     *
     * 示例 1：
     * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
     * 输出：true
     * 示例 2：
     * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
     * 输出：false
     * 提示：
     * 2 <= coordinates.length <= 1000
     * coordinates[i].length == 2
     * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
     * coordinates 中不含重复的点
     */
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 2) {
            return false;
        }
        if (coordinates[0][0] == coordinates[1][0]) {
            for (int i = 1; i < coordinates.length; i++) {
                if (coordinates[i][0] != coordinates[0][0]) {
                    return false;
                }
            }
            return true;
        }
        /*if (coordinates[0][1] == coordinates[1][1]) {
            for (int i = 1; i < coordinates.length; i++) {
                if (coordinates[i][1] != coordinates[0][1]) {
                    return false;
                }
            }
            return true;
        }
        */
        double k = (coordinates[1][1] - coordinates[0][1]) / (double) (coordinates[1][0] - coordinates[0][0]);
        for (int i = 2; i < coordinates.length; i++) {
            if ((coordinates[i][0] - coordinates[0][0]) == 0) {
                return false;
            }
            if (Double.valueOf((coordinates[i][1] - coordinates[0][1]) / (double)(coordinates[i][0] - coordinates[0][0])).compareTo(k) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q1232  q = new Q1232();
        q.checkStraightLine(new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}});
    }
}
