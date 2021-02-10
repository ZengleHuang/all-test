package com.spring13269.leetcode.Q501_600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Q514
 *
 * @author : zengle.huang@hand-china.com 2020/11/11
 */
public class Q514 {
    /**
     * 电子游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
     * 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
     * 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
     * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
     *
     * 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
     * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
     * 示例：
     * 输入: ring = "godding", key = "gd"
     * 输出: 4
     * 解释:
     *  对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
     *  对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
     *  当然, 我们还需要1步进行拼写。
     *  因此最终的输出是 4。
     * 提示：
     * ring 和 key 的字符串长度取值范围均为 1 至 100；
     * 两个字符串中都只有小写字符，并且均可能存在重复字符；
     * 字符串 key 一定可以由字符串 ring 旋转拼出。
     */
    public int findRotateSteps(String ring, String key) {
        int result = 0;
        int ringSize = ring.length();
        Map<Character, List<Integer>> keyMap = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            Character c = ring.charAt(i);
            List<Integer> l = keyMap.getOrDefault(c, new ArrayList<>());
            l.add(i);
            keyMap.put(c, l);
        }
        int current = 0;
        for (char c : key.toCharArray()) {
            int minStep = Integer.MAX_VALUE;
            int stepCurr = current;
            for (Integer integer : keyMap.get(c)) {
                int lenth1 = (integer + ringSize - current)%ringSize;
                Integer vp1 = Math.min(lenth1, ringSize - lenth1);
                if (vp1 < minStep) {
                    minStep = vp1;
                    stepCurr = integer;
                }
            }
            result += minStep;
            current = stepCurr;
            result +=1;
            /*int step = keyMap.get(c).stream().min((v1,v2) -> {
                int lenth1 = (v1 + ringSize - current)%ringSize;
                Integer vp1 = Math.min(lenth1, ringSize - lenth1);
                int lenth2 = (v2 + ringSize - current)%ringSize;
                Integer vp2 = Math.min(lenth2, ringSize - lenth2);
                return vp1.compareTo(vp2);
            }).orElse(0);
            result += step;
            result +=1;*/
        }
        
        return result;
    }

    public static void main(String[] args) {
        Q514 q = new Q514();
        System.out.println(q.findRotateSteps("sdfadsfasdf","afds"));
    }
}
