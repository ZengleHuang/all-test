package com.spring13269.leetcode.Q1201_1300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Q1207
 *
 * @author : zengle.huang@hand-china.com 2020/10/28
 */
public class Q1207 {
    /**
     * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
     * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     * 示例 1：
     * 输入：arr = [1,2,2,1,1,3]
     * 输出：true
     * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
     * 示例 2：
     * 输入：arr = [1,2]
     * 输出：false
     * 示例 3：
     * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
     * 输出：true
     * 提示：
     * 1 <= arr.length <= 1000
     * -1000 <= arr[i] <= 1000
     */
    public boolean uniqueOccurrences(int[] arr) {
        int[] values = new int[2100];
        for (int i : arr) {
            values[i+1000]++;
        }
        int[] nums = new int[1000];
        for (int value : values) {
            if (value != 0) {
                if (nums[value] != 0) {
                    return false;
                }
                nums[value] = 1;
            }
        }
        return true;



        /*try {

            Arrays.stream(arr).boxed()
                    .collect(Collectors.groupingBy(v -> v))
                    .entrySet()
                    .stream()
                    .collect(Collectors.toMap(v -> v.getValue().size(), Map.Entry::getKey, (v1, v2) -> {
                        throw new RuntimeException();
                    }));
            return true;
        } catch (Exception e) {
            return false;
        }*/
    }

    public static void main(String[] args) {
        Q1207 q = new Q1207();
        q.uniqueOccurrences(new int[]{1,2,3,4,5});
    }
}
