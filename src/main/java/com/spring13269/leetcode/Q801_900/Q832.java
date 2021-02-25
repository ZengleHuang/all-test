package com.spring13269.leetcode.Q801_900;

/**
 * Q832
 *
 * @author : zengle.huang@hand-china.com 2021/2/24
 */
public class Q832 {
    /**
     * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
     * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
     * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
     *  
     * 示例 1：
     * 输入：[[1,1,0],[1,0,1],[0,0,0]]
     * 输出：[[1,0,0],[0,1,0],[1,1,1]]
     * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
     * 示例 2：
     * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
     * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     *
     * 提示：
     * 1 <= A.length = A[0].length <= 20
     * 0 <= A[i][j] <= 1
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int length = A.length > 0 ? A[0].length : A.length;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0, k = length - 1; j <= k; j++, k--) {
                if (j == k) {
                    A[i][j] = A[i][j] == 0 ? 1 : 0;
                    break;
                }
                int temp = A[i][j] == 0 ? 1 : 0;
                A[i][j] = A[i][k] == 0 ? 1 : 0;
                A[i][k] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Q832 q = new Q832();
        q.flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}});
    }
}
