package com.spring13269.leetcode.Q401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * Q406
 *
 * @author : zengle.huang@hand-china.com 2020/11/16
 */
public class Q406 {
    /**
     * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
     * 注意：
     * 总人数少于1100人。
     * 示例
     * 输入:
     * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     * 输出:
     * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     */
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length < 1) {
            return people;
        }
        //int[][] result = new int[people.length][2];
        List<Integer> result = new ArrayList<>(people.length);
        List<Integer[]> notSureLisst = new ArrayList<>();
        int length = 0;
        for (int i = 0; i < people.length; i++) {
            if (people[i][1] > result.size()+1) {
                continue;
            }
            int numCount = 0;
            int j = 0;
            while (numCount <= people[i][1] && j <= result.size()) {
                if (result.get(j) >= people[i][0]) {
                    numCount++;
                }
                j++;
            }
        }




        return people;
    }
}
