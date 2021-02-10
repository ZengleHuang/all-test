package com.spring13269.leetcode.Q0_100;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 * Q37
 *
 * @author : zengle.huang@hand-china.com 2020/9/15
 */
public class Q37 {
    /**
     * 编写一个程序，通过已填充的空格来解决数独问题。
     *
     * 一个数独的解法需遵循如下规则：
     *
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * 空白格用 '.' 表示。

     Note:
     给定的数独序列只包含数字 1-9 和字符 '.' 。
     你可以假设给定的数独只有唯一解。
     给定数独永远是 9x9 形式的。

     [
     ["5","3",".",".","7",".",".",".","."],
     ["6",".",".","1","9","5",".",".","."],
     [".","9","8",".",".",".",".","6","."],
     ["8",".",".",".","6",".",".",".","3"],
     ["4",".",".","8",".","3",".",".","1"],
     ["7",".",".",".","2",".",".",".","6"],
     [".","6",".",".",".",".","2","8","."],
     [".",".",".","4","1","9",".",".","5"],
     [".",".",".",".","8",".",".","7","9"]
     ]


     [
     ["5","3","4","6","7","8","9","1","2"],
     ["6","7","2","1","9","5","3","4","8"],
     ["1","9","8","3","4","2","5","6","7"],
     ["8","5","9","7","6","1","4","2","3"],
     ["4","2","6","8","5","3","7","9","1"],
     ["7","1","3","9","2","4","8","5","6"],
     ["9","6","1","5","3","7","2","8","4"],
     ["2","8","7","4","1","9","6","3","5"],
     ["3","4","5","2","8","6","1","7","9"]
     ]
     */
    Map<Integer, Set<Integer>> heng = new HashMap(9){{
        put(0, new HashSet<>(9));
        put(1, new HashSet<>(9));
        put(2, new HashSet<>(9));
        put(3, new HashSet<>(9));
        put(4, new HashSet<>(9));
        put(5, new HashSet<>(9));
        put(6, new HashSet<>(9));
        put(7, new HashSet<>(9));
        put(8, new HashSet<>(9));
    }};
    Map<Integer, Set<Integer>> zong = new HashMap(9){{
        put(0, new HashSet<>(9));
        put(1, new HashSet<>(9));
        put(2, new HashSet<>(9));
        put(3, new HashSet<>(9));
        put(4, new HashSet<>(9));
        put(5, new HashSet<>(9));
        put(6, new HashSet<>(9));
        put(7, new HashSet<>(9));
        put(8, new HashSet<>(9));
    }};
    Map<Integer, Set<Integer>> kuai = new HashMap(9){{
        put(0, new HashSet<>(9));
        put(1, new HashSet<>(9));
        put(2, new HashSet<>(9));
        put(3, new HashSet<>(9));
        put(4, new HashSet<>(9));
        put(5, new HashSet<>(9));
        put(6, new HashSet<>(9));
        put(7, new HashSet<>(9));
        put(8, new HashSet<>(9));
        put(9, new HashSet<>(9));
    }};
    Queue<Map<Point, List<Integer>>> mayValueSet = new LinkedBlockingQueue();

    // 可能的key的size
    Map<Integer, Map<Point, List<Long>>> mayKey = new HashMap(9){{
        mayKey.put(2, new HashMap<>());
        mayKey.put(3, new HashMap<>());
        mayKey.put(4, new HashMap<>());
        mayKey.put(5, new HashMap<>());
        mayKey.put(6, new HashMap<>());
        mayKey.put(6, new HashMap<>());
        mayKey.put(6, new HashMap<>());
    }};

    public void solveSudoku(char[][] board) {
        if (board.length != 9) {
            return;
        }
        if (board[0].length != 9) {
            return;
        }

        // 初始化已有的值
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Objects.equals('.', board[i][j])) {

                } else {
                    int value = board[i][j] - '0';
                    addValue(i, j, value);
                }
            }
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            // 打印当前对象
            outBo(board);
            // 循环进行匹配， 匹配一遍都没找到某一个可以确定的，先直接退出
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (Objects.equals('.', board[i][j])) {
                        List<Integer> posi = getPosiValue(i, j);
                        if (posi.size() == 1) {
                            board[i][j] = (char)(posi.get(0) + '0');
                            flag = true;
                            addValue(i,j, posi.get(0));
                        }
                    }
                }
            }
        }
    }

    private void outBo(char[][] board) {
        System.out.println("============================================");
        Arrays.stream(board)
                .forEach(v -> System.out.println(Arrays.toString(v)));
        System.out.println();
    }

    private void addValue(int i, int j, int value) {
        heng.getOrDefault(i, new HashSet<>(9)).add(value);
        zong.getOrDefault(j, new HashSet<>(9)).add(value);
        kuai.getOrDefault(((i/3)*3 + (j)/3), new HashSet<>(9)).add(value);
    }

    List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
    private List<Integer> getPosiValue(int i, int j) {
        return nums.stream()
                .filter(v -> !heng.get(i).contains(v))
                .filter(v -> !zong.get(j).contains(v))
                .filter(v -> !kuai.get((i/3)*3 + (j)/3).contains(v))
                .collect(Collectors.toList());
    }



    class Point {
        int value; // 层级, 代表第几次猜测
        int x;
        int y;

        Point(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    public static void main(String[] args) {
        Q37 q = new Q37();
        // 每次都可以确定到唯一值
        q.solveSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}}
        );
        /**
         *
         * [[".",".","9","7","4","8",".",".","."],["7",".",".",".",".",".",".",".","."],[".","2",".","1",".","9",".",".","."],[".",".","7",".",".",".","2","4","."],[".","6","4",".","1",".","5","9","."],[".","9","8",".",".",".","3",".","."],[".",".",".","8",".","3",".","2","."],[".",".",".",".",".",".",".",".","6"],[".",".",".","2","7","5","9",".","."]]
         *
         *
         * [
         * [".",".","9","7","4","8",".",".","."],
         * ["7",".",".","6",".","2",".",".","."],
         * [".","2",".","1",".","9",".",".","."],
         * [".",".","7","9","8","6","2","4","1"],
         * ["2","6","4","3","1","7","5","9","8"],
         * ["1","9","8","5","2","4","3","6","7"],
         * [".",".",".","8","6","3",".","2","."],
         * [".",".",".","4","9","1",".",".","6"],
         * [".",".",".","2","7","5","9",".","."]]
         */
    }
}
