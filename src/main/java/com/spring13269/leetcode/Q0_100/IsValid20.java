package com.spring13269.leetcode.Q0_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * IsValid20 description
 *
 * @author zengle.huang@hand-china.com  2019/11/28
 * @version 1.0
 */
public class IsValid20 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串
     *
     */

    public static boolean isValid(String s) {
        char[] nums = new char[s.length() + 1];
        int last = 0;
        for (int i=0; i<s.length(); i++) {
            char var = s.charAt(i);
            if (Objects.equals(")".charAt(0),var)|| Objects.equals("]".charAt(0), var)
                    || Objects.equals("}".charAt(0), var)) {
                if (last <=0) {
                    return false;
                } else if (Objects.equals(")".charAt(0),var) && !Objects.equals("(".charAt(0), nums[last])) {
                    return false;
                } else if (Objects.equals("]".charAt(0),var) && !Objects.equals("[".charAt(0), nums[last])) {
                    return false;
                } else if (Objects.equals("}".charAt(0),var) && !Objects.equals("{".charAt(0), nums[last])) {
                    return false;
                } else {
                    last--;
                }
            } else if (" ".equals(var)) {
                continue;
            } else {
                last++;
                nums[last] = var;
            }

        }
        return last == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

}
