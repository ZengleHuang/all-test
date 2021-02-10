package com.spring13269.leetcode.Q1201_1300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Q1282 description
 *
 * @author zengle.huang@hand-china.com  2019/12/12
 * @version 1.0
 */
public class Q1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>(groupSizes.length/2);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i< groupSizes.length; i++) {
            List<Integer> list;
            if (map.containsKey(groupSizes[i])) {
                list = map.get(groupSizes[i]);
                list.add(i);
                if (list.size() == groupSizes[i]) {
                    result.add(list);
                    map.remove(groupSizes[i]);
                } else {
                    map.put(groupSizes[i], list);
                }
            } else if (groupSizes[i] == 1) {
                list = new ArrayList<>(2);
                list.add(i);
                result.add(list);
            } else {
                list = new ArrayList<>(groupSizes[i]);
                list.add(i);
                map.put(groupSizes[i], list);
            }
        }
        result.addAll(map.values());

        return result;
    }
}
