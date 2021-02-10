package com.spring13269.leetcode.Q0_100;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Q13 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * @author zengle.huang@hand-china.com  2020/2/5
 * @version 1.0
 */
public class Q13 {

    static char[] romans = {'I','V','X','L','C','D','M'};
    int[] nums = {1,5,10,50,100,500,1000};

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public int romanToInt(String s) {
        Integer last = null;
        int result = 0;
        for (int i=0;i < s.length(); i++) {
            char c = s.charAt(i);
            int value = getValue(c);
            if (last!=null && last<value) {
                result = result - last - last;
            }
            last = value;
            result += value;
            /*for (int j = 6; j>=0; j--) {
                if (c == romans[j]) {
                    if (last!=null && last<nums[j]) {
                        result = result - last - last;
                    }
                    last = nums[j];
                    result += nums[j];
                }
            }*/
        }
        return result;
    }

    public static void main(String[] args) {
        //romanToInt


    }
}
