package com.spring13269.leetcode.Q1101_1200;

/**
 * LongestDecomposition1147 description
 *
 * @author zengle.huang@hand-china.com  2019/11/28
 * @version 1.0
 */
public class LongestDecomposition1147 {
    public static int longestDecomposition(String text) {
        int result = 0;
        int i = 0;
        int j = text.length() - 1;
        int k = 1;
        for (;i<(text.length()+1)/2 && j>(text.length()-1)/2;) {
            if(text.charAt(i)==text.charAt(j)){
                if (text.substring(i,i+k).equals(text.substring(j, text.length() - i))) {
                    result +=2;
                    i+=k;
                    // j重置
                    j = text.length() - i - 1;
                    k=1;
                } else {
                    j--;
                    k++;
                }
            } else {
                j--;
                k++;
            }
        }
        if (i <= j){
            result++;
        }
        return result;
    }

    public static void main(String[] arg) {
        System.out.println(longestDecomposition("abab"));
    }
}
