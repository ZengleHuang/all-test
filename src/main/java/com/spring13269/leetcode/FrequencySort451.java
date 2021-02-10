package com.spring13269.leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * FrequencySort451 description
 *
 * @author zengle.huang@hand-china.com  2019/11/27
 * @version 1.0
 */
public class FrequencySort451 {
    public String frequencySort(String s) {
        Map<Character, Integer> charNums = new HashMap<>(52);
        for (int i = 0; i < s.length(); i ++) {
            char num = s.charAt(i);
            Integer count = charNums.getOrDefault(num, 0);
            charNums.put(num, ++count);
            continue;
        }


        StringBuilder sb = new StringBuilder();
        return charNums.entrySet().stream()
                .sorted((entry1, entry2) -> entry1.getValue() - entry2.getValue())
                .map(entry -> String.join("",Collections.nCopies(entry.getValue(), String.valueOf(entry.getKey()))))
                .reduce("", String::concat);
    }
}
