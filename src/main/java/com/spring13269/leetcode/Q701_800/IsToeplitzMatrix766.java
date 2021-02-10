package com.spring13269.leetcode.Q701_800;

/**
 * IsToeplitzMatrix766 description
 *
 * @author zengle.huang@hand-china.com  2019/11/27
 * @version 1.0
 */
public class IsToeplitzMatrix766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return true;
        }
        int y = matrix.length;
        int x = matrix[0].length;
        int max = y > x ? y : x;
        for (int i = 1; i < max & i < matrix.length; i++) {
            int[] lineI = matrix[i];
            if (lineI == null) {
                return true;
            }
            for (int j = 1; j < max && j <lineI.length; j ++) {
                if (matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
}
