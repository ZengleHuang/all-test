package com.spring13269.leetcode.Q0_100;

/**
 * QM_58 description
 *
 * @author zengle.huang@hand-china.com  2020/3/4
 * @version 1.0
 */
public class QM_58 {
    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * @param s S
     * @param n N
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        char[] result = new char[s.length()];
        char[] origin = s.toCharArray();
        int length = s.length();
        for (int i =0, j = n; i < length; i++, j++) {

            //int point =  (i > n ? (i - n) : length + i -n)%length;
            //result[point] = s.charAt(i);
            result[i] = origin[j%length];
            i++;
        }
        //s.substring()
        return String.valueOf(result);
    }

    /*{
    return s.substring(n, s.length())
               + s.substring(0, n) ;
    }*/
}
