package com.spring13269.leetcode.Q201_300;

import java.util.HashSet;
import java.util.Set;

/**
 * Q202
 *
 * @author : zengle.huang@hand-china.com 2020/9/26
 */
public class Q202 {
    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     *
     * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
     *
     * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
     *
     *  
     *
     * 示例：
     *
     * 输入：19
     * 输出：true
     * 解释：
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     */
    Set<Integer> exist = new HashSet<>(20);
    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        } else if (n == 1) {
            return true;
        } else {
            while (true){
                int num = plSum(n);
                if (num == 1) {
                    return true;
                }else if (exist.contains(num)) {
                    return false;
                } else {
                    exist.add(num);
                    n = num;
                }
            }
        }
    }

    public int plSum(int num) {
        int result = 0;
        while (num>0) {
            int tem = num%10;
            result += tem*tem;
            num/=10;
        }
        System.out.println("num:"+num+"的循环："+ result);
        return result;
    }
    public static void main(String[] args) {
        Q202 q = new Q202();
        q.isHappy(19);
    }
}
