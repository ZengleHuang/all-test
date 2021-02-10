package com.spring13269.leetcode.Q0_100;

import java.util.Arrays;

/**
 * Q48
 *
 * @author : zengle.huang@hand-china.com 2020/12/21
 */
public class Q48 {
    /**
     * 给定一个 n × n 的二维矩阵表示一个图像。
     * 将图像顺时针旋转 90 度。
     *
     * 说明：
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     *
     * 示例 1:
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     * 示例 2:
     * 给定 matrix =
     * [
     *   [ 5, 1, 9,11],
     *   [ 2, 4, 8,10],
     *   [13, 3, 6, 7],
     *   [15,14,12,16]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [15,13, 2, 5],
     *   [14, 3, 4, 1],
     *   [12, 6, 8, 9],
     *   [16, 7,10,11]
     * ]
     *
     *
     * i行j 列 转为 j行 n-i列   j行 n-i列 转为 n-i 行 n-j 列    n-i 行 n-j 列 转为 n-j 行 i列    n-j 行 i列 转为 i行j 列
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return;
        }
        n = n-1;
        for (int i = 0; i<matrix.length/2; i++) {
            for (int j = 0; j< matrix.length/2; j++) {
                int rb = matrix[n -j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = matrix[j][n-i];
                matrix[j][n-i] = matrix[i][j];
                matrix[i][j] = rb;
            }
        }
        if (matrix.length % 2 == 1) {
            int mid = matrix.length /2;
            for (int j = 0; j< matrix.length/2; j++) {
                int rb = matrix[n -j][mid];
                matrix[n-j][mid] = matrix[mid][n-j];
                matrix[mid][n-j] = matrix[j][mid];
                matrix[j][mid] = matrix[mid][j];
                matrix[mid][j] = rb;
            }
        }
        Arrays.stream(matrix).forEach(v -> {
            Arrays.stream(v).forEach(vl -> System.out.print(vl+"\t"));
            System.out.println();
        });
    }

    public static void main(String[] args) {
        Q48 q = new Q48();
        q.rotate(new int[][]{
                {1,2,3,4,5},
                {5,6,7,8,9},
                {9,10,11,12,13},
                {13,14,15,16,17},
                {13,14,15,16,17}
        });
    }
}
