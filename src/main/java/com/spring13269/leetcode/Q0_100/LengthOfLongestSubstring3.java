package com.spring13269.leetcode.Q0_100;

import java.util.HashMap;
import java.util.Map;

/**
 * LengthOfLongestSubstring3 description
 *
 * @author zengle.huang@hand-china.com  2019/11/29
 * @version 1.0
 */
public class LengthOfLongestSubstring3 {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charPoint = new HashMap<>(s.length());
        int result = 0;
        int sum = 0;
        int lastSavePoint = 0;
        for (int position = 0; position < s.length(); position++) {
            char a = s.charAt(position);
            if (charPoint.containsKey(a)) {
                int lastPoint = charPoint.get(a);
                charPoint.put(a, position);

                System.out.println("char " + a + " position " + position + " lastPosition " + lastPoint);
                System.out.println("sum " + sum + " result " + result);
                if (sum >= result) {
                    result = sum;
                    sum = position - lastPoint;
                } else {
                    lastSavePoint++;
                    sum = position -lastSavePoint;
                }
            } else {
                charPoint.put(a, position);
                sum++;
            }
        }
        result = sum > result ? sum : result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("asdfghhhhhhhadsfqwerasdf"));
    }


}
