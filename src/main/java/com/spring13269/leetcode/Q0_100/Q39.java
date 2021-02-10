package com.spring13269.leetcode.Q0_100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Q39
 *
 * @author : zengle.huang@hand-china.com 2020/9/9
 */
public class Q39 {
    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     *
     * 说明：
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1：
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * 示例 2：
     * 输入：candidates = [2,3,5], target = 8,
     * 所求解集为：
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     * 提示：
     * 1 <= candidates.length <= 30
     * 1 <= candidates[i] <= 200
     * candidate 中的每个元素都是独一无二的。
     * 1 <= target <= 500
     *
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer, List<List<Integer>>> data = new HashMap<>(target);
        int[] dataExist = new int[target+1];
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                // 初始化构造
                List<Integer> c = new ArrayList<>(1);
                c.add(candidates[i]);
                List<List<Integer>> b = new ArrayList<>();
                b.add(c);
                data.put(candidates[i], b);
                dataExist[candidates[i]] = 1;
            }
        }
        for (int i = 1; i <= target; i++) {
            List<List<Integer>> chi = data.getOrDefault(i, new ArrayList<>(target));
            for (int j = 1; j <= i/2; j++) {
                if (dataExist[j] != 1) {
                    continue;
                } else if (j < (i-j) && dataExist[i-j] == 1) {
                    continue;
                }
                List<List<Integer>> chiAdd = data.getOrDefault(i-j, new ArrayList<>(target));
                if (chiAdd.size()>0) {
                    for (List<Integer> integers : chiAdd) {
                        List<Integer> jie1 = new ArrayList<>(integers);
                        jie1.add(j);
                        chi.add(jie1);
                    }
                }
                data.put(i, chi);
            }
        }
        return data.getOrDefault(target, Collections.emptyList());
    }

    public static void main(String[] args) {
        combinationSum(new int[]{2,3,5}, 8);
    }

}
