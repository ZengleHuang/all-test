package com.spring13269.leetcode.Q0_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q57
 *
 * @author : zengle.huang@hand-china.com 2020/11/4
 */
public class Q57 {
    /**
     * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     *
     * 示例 1：
     * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出：[[1,5],[6,9]]
     * 示例 2：
     * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * 输出：[[1,2],[3,10],[12,16]]
     * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
     *
     * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        if (intervals[0][0] > newInterval[1]) {
            int[][] res =  new int[intervals.length+1][2];
            res[0] = newInterval;
            System.arraycopy(intervals, 0, res, 1, intervals.length);
            return res;
        }
        if (intervals[0][0] > newInterval[0]) {
            intervals[0][0] = newInterval[0];
        }
        List<int[]> result = new ArrayList<>(intervals.length);
        boolean has = false;
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                result.add(interval);
            } else if (interval[0] > newInterval[1]) {
                if (!has) {

                }
                result.add(interval);
            }
            if (interval[0] <= newInterval[0] && interval[1] > newInterval[0]) {
                if (interval[1] < newInterval[1]) {
                    interval[1] = newInterval[1];
                }
                interval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        return null;
    }
}
