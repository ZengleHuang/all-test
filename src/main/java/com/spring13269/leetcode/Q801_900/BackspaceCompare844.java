package com.spring13269.leetcode.Q801_900;

import java.util.Objects;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * BackspaceCompare844 description
 *
 * @author zengle.huang@hand-china.com  2019/12/5
 * @version 1.0
 */
public class BackspaceCompare844 {
    public static boolean backspaceCompare(String S, String T) {
        return toNoSString(S).equals(toNoSString(T));
    }

    private static String toNoSString(String s) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i<s.length(); i++) {
            if (Objects.equals("#".charAt(0),s.charAt(i))) {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length()-1);
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static boolean backspaceCompare1(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for (int i = 0; i< S.length(); i++) {
            if (Objects.equals("#".charAt(0),S.charAt(i))) {
                if (!sStack.isEmpty()) {
                    sStack.pop();
                }
            } else {
                sStack.push(S.charAt(i));
            }
        }
        for (int i = 0; i< T.length(); i++) {
            if (Objects.equals("#".charAt(0),T.charAt(i))) {
                if (!tStack.isEmpty()) {
                    tStack.pop();
                }
            } else {
                tStack.push(T.charAt(i));
            }
        }
        if (sStack.size() != tStack.size()) {
            return false;
        }
        for (int i = 0; i<sStack.size(); i++) {
            if (!sStack.get(i).equals(tStack.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("adsfadsf#asdf","#adsf"));
    }

    /*
    String pa = "[a-z]#";
        String replacement = "";
        Pattern pattern = Pattern.compile(pa);
        Matcher matcher = pattern.matcher(S);
        String sre = matcher.replaceAll(replacement);
        System.out.println(sre);
        matcher = pattern.matcher(T);
        String tre = matcher.replaceAll(replacement);
        System.out.println(tre);
        return sre.replace("#","").equals(tre.replace("#",""));
        */
}
