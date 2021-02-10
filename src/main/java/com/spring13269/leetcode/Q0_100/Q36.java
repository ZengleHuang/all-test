package com.spring13269.leetcode.Q0_100;

import java.util.HashMap;
import java.util.Map;

/**
 * Q36 description
 *
 * @author zengle.huang@hand-china.com  2019/12/6
 * @version 1.0
 */
public class Q36 {
    /**
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     *
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     *
     * 说明:
     *
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 给定数独序列只包含数字 1-9 和字符 '.' 。
     * 给定数独永远是 9x9 形式的。
     *
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        Map<Character, Map<Integer, Integer>> count = new HashMap<>(9);
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                if (board[i][j]!='.') {
                    Map<Integer,Integer> position = count.getOrDefault(board[i][j], new HashMap<>(9));
                    // 如果当前行已经有key  或者列已经有当前值
                    if (position.containsKey(i) || position.containsValue(j)) {
                        return false;
                    } else {
                        int m = (i/3)*3, n = (j/3)*3, o = (i/3 +1)*3, p = (j/3 +1)*3;
                        for (int positioni = m; positioni<o; positioni++) {
                            for (int positionj = n; positionj<p; positionj++) {
                                if (positioni != i && board[positioni][positionj] == board[i][j]) {
                                    return false;
                                }
                            }
                        }
                    }
                    position.put(i,j);
                    count.put(board[i][j], position);

                }
            }
        }
        return true;
    }

    //[['5','3','.','.','7','.','.','.','.'],
    // ['6','.','.','1','9','5','.','.','.'],
    // ['.','9','8','.','.','.','.','6','.'],
    // ['8','.','.','.','6','.','.','.','3'],
    // ['4','.','.','8','.','3','.','.','1'],
    // ['7','.','.','.','2','.','.','.','6'],
    // ['.','6','.','.','.','.','2','8','.'],
    // ['.','.','.','4','1','9','.','.','5'],
    // ['.','.','.','.','8','.','.','7','9']]
    public static void main(String[] args) {
        char[][] nums = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(nums));
    }


}
