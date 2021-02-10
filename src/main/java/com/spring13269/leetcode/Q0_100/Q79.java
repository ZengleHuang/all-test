package com.spring13269.leetcode.Q0_100;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Q79
 *
 * @author : zengle.huang@hand-china.com 2020/9/13
 */
public class Q79 {
    /**
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * <p>
     * 示例:
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * 给定 word = 'ABCCED', 返回 true
     * 给定 word = 'SEE', 返回 true
     * 给定 word = 'ABCB', 返回 false
     *  
     * 提示：
     * board 和 word 中只包含大写和小写英文字母。
     * 1 <= board.length <= 200
     * 1 <= board[i].length <= 200
     * 1 <= word.length <= 10^3
     */
    private int iLength;
    private int jLength;
    private Map<Character, Set<Point>> keyMap;
    private String word;
    char[][] board;
    private Map<Point, Map<Character, List<Point>>> dataValMap;

    class Point {
        int x;
        int y;

        Point(int x, int y) {
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

        public boolean near(int newX, int newY) {
            if (newX < 0 || newX > iLength || newY < 0 || newY > jLength) {
                return false;
            }
            if (newX == x) {
                return newY - y == 1 || y - newY == 1;
            } else if (newY == y) {
                return newX - x == 1 || x - newX == 1;
            } else {
                return false;
            }
        }

        public void out() {
            System.out.print(board[x][y] + " " + x + "/" + y + "   ");
        }
    }

    public boolean exist(char[][] board, String word) {
        if (word.length() < 1) {
            return true;
        }
        this.iLength = board.length;
        if (iLength < 1) {
            return false;
        }
        this.jLength = board[0].length;
        this.keyMap = new HashMap<>(30);
        Map<Point, Map<Character, List<Point>>> dataValMap = new HashMap<>(iLength * jLength);
        for (int i = 0; i < iLength; i++) {
            for (int j = 0; j < jLength; j++) {
                Set<Point> keyValue = keyMap.getOrDefault(board[i][j], new HashSet<>(10));
                Point p = new Point(i, j);
                keyValue.add(p);
                keyMap.put(board[i][j], keyValue);

                Map<Character, List<Point>> valMap = new HashMap<>(4);
                if (i > 0) {
                    // valMap.put(board[i][j], Collections.singletonList(new Point(i-1,j)));
                    char v = board[i - 1][j];
                    List<Point> pL = valMap.getOrDefault(v, new ArrayList<>(4));
                    pL.add(new Point(i - 1, j));
                    valMap.put(v, pL);
                }
                if (i < iLength - 1) {
                    char v = board[i + 1][j];
                    List<Point> pL = valMap.getOrDefault(v, new ArrayList<>(3));
                    pL.add(new Point(i + 1, j));
                    valMap.put(v, pL);
                }
                if (j < jLength - 1) {
                    char v = board[i][j + 1];
                    List<Point> pL = valMap.getOrDefault(v, new ArrayList<>(2));
                    pL.add(new Point(i, j + 1));
                    valMap.put(v, pL);
                }
                if (j > 0) {
                    char v = board[i][j - 1];
                    List<Point> pL = valMap.getOrDefault(v, new ArrayList<>(4));
                    pL.add(new Point(i, j - 1));
                    valMap.put(v, pL);
                }
                dataValMap.put(p, valMap);
            }
        }
        this.dataValMap = dataValMap;
        this.word = word;
        this.board = board;
        for (char c : word.toCharArray()) {
            // 任意一个字符不存在 直接返回false
            if (!keyMap.containsKey(c)) {
                return false;
            }
        }
        char c = word.charAt(0);
        Set<Point> keyValue = keyMap.get(c);
        for (Point point : keyValue) {
            Set<Point> wordCList = new HashSet<>(word.length());
            wordCList.add(point);
            if (pick(1, point, wordCList)) {
                return true;
            }
        }
        return false;
    }

    public boolean pick(int now, Point point, Set<Point> wordCList) {
        if (now >= word.length()) {
            return true;
        }
        //System.out.println("===============" );
        //keyMap.get(word.charAt(now)).forEach(Point::out);
        //System.out.println("===============");
        Map<Character, List<Point>> valMap = dataValMap.getOrDefault(point, new HashMap<>());
        if (valMap.containsKey(word.charAt(now))) {
            return valMap.get(word.charAt(now))
                    .stream()
                    .filter(v -> !wordCList.contains(v))
                    .anyMatch(val -> {
                        wordCList.add(val);
                        System.out.print(wordCList.size() + "       ");
                        wordCList.forEach(Point::out);
                        System.out.println();

                        /*Set<Point> newUsed = new LinkedHashSet<>(wordCList);
                        newUsed.add(val);*/
                        System.out.println("x: " + val.x + " y:" + val.y);
                        //return pick(now + 1, val, newUsed);
                        boolean res = pick(now + 1, val, wordCList);
                        if (res) {
                            return true;
                        } else {
                            wordCList.remove(val);
                            return false;
                        }
                    });
        } else {
            return false;
        }


        /*return keyMap.get(word.charAt(now))
                .stream()
                //.peek(v -> System.out.println("x: " + v.x + " y:" + v.y))
                .anyMatch(val -> {
                    if (!point.near(val.x, val.y)) {
                        return false;
                    }
                    System.out.println("x: " + val.x + " y:" + val.y);
                    //Set<Point> newUsed = new LinkedHashSet<>(wordCList);
                    //newUsed.add(val);
                    wordCList.add(val);
                    System.out.print(wordCList.size() + "       ");
                    wordCList.forEach(Point::out);
                    System.out.println();
                    boolean res = !wordCList.contains(val) && pick(now + 1, val, wordCList);
                            if (res) {
                                return true;
                            } else {
                                wordCList.remove(val);
                                return false;
                            }
                    //return point.near(val.x, val.y) && !wordCList.contains(val) && pick(now + 1, val, newUsed);
                });*/
    }

    //[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]
    //'ABCB'
    public static void main(String[] args) {
        Q79 v = new Q79();
        boolean result = v.exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}}, "ABCCED");
        //v.exist(new char[][]{{'a'}}, 'ab');
        /*boolean result = v.exist(new char[][]{new char[]{'c', 'a', 'a'},
                new char[]{'a', 'a', 'a'},
                new char[]{'b', 'c', 'd'}}, 'aab');*/
        ///[['a','c','b','c','b','c','c','a','b'],
        // ['a','a','b','b','c','a','a','b','a'],
        // ['c','b','b','b','c','b','b','c','c'],
        // ['a','a','c','b','a','a','a','a','c'],
        // ['b','c','c','c','b','c','c','a','c'],
        // ['a','a','b','b','c','c','b','b','b'],
        // ['c','a','b','a','a','c','a','a','c'],
        // ['a','a','a','c','b','a','c','c','b'],
        // ['c','c','b','b','c','c','a','c','b'],
        // ['a','a','b','c','c','b','b','c','c'],
        // ['a','b','a','b','b','b','b','c','a'],
        // ['c','b','a','b','b','c','a','a','a'],
        // ['c','c','c','c','c','c','a','c','c'],
        // ['c','b','a','c','b','b','a','a','a']]
        //'ccacccbbbbb'
        /*boolean result = v.exist(new char[][]{
                        {'a', 'c', 'b', 'c', 'b', 'c', 'c', 'a', 'b'},//0
                        {'a', 'a', 'b', 'b', 'c', 'a', 'a', 'b', 'a'},//1
                        {'c', 'b', 'b', 'b', 'c', 'b', 'b', 'c', 'c'},
                        {'a', 'a', 'c', 'b', 'a', 'a', 'a', 'a', 'c'},//3
                        {'b', 'c', 'c', 'c', 'b', 'c', 'c', 'a', 'c'},
                        {'a', 'a', 'b', 'b', 'c', 'c', 'b', 'b', 'b'},//5  ****
                        {'c', 'a', 'b', 'a', 'a', 'c', 'a', 'a', 'c'},
                        {'a', 'a', 'a', 'c', 'b', 'a', 'c', 'c', 'b'},//7
                        {'c', 'c', 'b', 'b', 'c', 'c', 'a', 'c', 'b'},
                        {'a', 'a', 'b', 'c', 'c', 'b', 'b', 'c', 'c'},//9
                        {'a', 'b', 'a', 'b', 'b', 'b', 'b', 'c', 'a'},
                        {'c', 'b', 'a', 'b', 'b', 'c', 'a', 'a', 'a'},//11
                        {'c', 'c', 'c', 'c', 'c', 'c', 'a', 'c', 'c'},
                        {'c', 'b', 'a', 'c', 'b', 'b', 'a', 'a', 'a'}}//13
                , "ccacccbbbbb");*/


        System.out.println(result);
    }

}
