package com.spring13269.leetcode.Q1101_1200;

/**
 * Q1128
 *
 * @author : zengle.huang@hand-china.com 2021/1/26
 */
public class Q1128 {
    /**
     * 给你一个由一些多米诺骨牌组成的列表 dominoes。
     * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
     * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
     * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
     *  
     * 示例：
     * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
     * 输出：1
     * 提示：
     * 1 <= dominoes.length <= 40000
     * 1 <= dominoes[i][j] <= 9
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] nums = new int[10][10];
        int result = 0;
        for (int i = 0; i < dominoes.length; i++) {
            int x = dominoes[i][0];
            int y = dominoes[i][1];
            nums[x][y] ++;
            if (x != y) {
                nums[y][x]++;
            }
            int cou = nums[x][y];
            if (cou >= 2) {
                result = result + cou -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q1128 q = new Q1128();
        q.numEquivDominoPairs(new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}});
    }
}
