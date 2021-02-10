package com.spring13269.leetcode.LCP;

/**
 * LCP17
 *
 * @author : zengle.huang@hand-china.com 2020/10/1
 */
public class LCP17 {
    /**
     * 小扣在秋日市集发现了一款速算机器人。店家对机器人说出两个数字（记作 x 和 y），请小扣说出计算指令：
     *
     * "A" 运算：使 x = 2 * x + y；
     * "B" 运算：使 y = 2 * y + x。
     * 在本次游戏中，店家说出的数字为 x = 1 和 y = 0，小扣说出的计算指令记作仅由大写字母 A、B 组成的字符串 s，字符串中字符的顺序表示计算顺序，请返回最终 x 与 y 的和为多少。
     *
     * 示例 1：
     * 输入：s = "AB"
     * 输出：4
     * 解释：
     * 经过一次 A 运算后，x = 2, y = 0。
     * 再经过一次 B 运算，x = 2, y = 2。
     * 最终 x 与 y 之和为 4。
     *
     * 提示：
     * 0 <= s.length <= 10
     * s 由 'A' 和 'B' 组成
     */
    public int calculate(String s) {
        int x = 1;
        int y = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                x = 2 * x + y;
            } else if (c == 'B') {
                y = 2 * y + x;
            }
        }
        // 后一位与前一位相比
        /**
         *  1 ->  x + y
         *  2 ->  2x+y + y   或   x + 2y+x
         *  3 ->  2(2x+y)+y + y =  4x + 4y || (2x+y) + 2y + (2x+y) = 4x+ 4y  ||     (2x + 2y+x) + (2y+x) = 4x+ 4y ||  x + 2(2y+x) + x =  4x+ 4y
         */
        return (x+y) << s.length();
        //return x+y;
    }
}
