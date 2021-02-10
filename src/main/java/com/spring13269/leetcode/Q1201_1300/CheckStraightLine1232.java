package com.spring13269.leetcode.Q1201_1300;

/**
 * CheckStraightLine1232 description
 *
 * @author zengle.huang@hand-china.com  2019/11/27
 * @version 1.0
 */
public class CheckStraightLine1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 0) {
            return false;
        }
        if (coordinates.length <= 2) {
            return true;
        }
        // y = kx + a
        int[] point1 = coordinates[0];
        int[] point2 = coordinates[1];

        if (point1[0] == point2[0]) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != point1[0]) {
                    return false;
                }
            }
        }

        float k = (point2[1] - point1[1]) / (point2[0] - point1[0]);
        float a = point1[1] - k * point1[0];
        for (int i = 2; i < coordinates.length; i++) {
            int[] point = coordinates[i];
            if (k * point[0] + a != point[1]) {
                return false;
            }
        }
        return true;
    }
}
