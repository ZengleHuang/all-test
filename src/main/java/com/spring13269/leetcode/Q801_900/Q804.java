package com.spring13269.leetcode.Q801_900;

import java.util.HashSet;
import java.util.Set;

/**
 * Q804 description
 *
 * @author zengle.huang@hand-china.com  2019/12/13
 * @version 1.0
 */
public class Q804 {
    public int uniqueMorseRepresentations(String[] words) {
        final String[] mores = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> result = new HashSet<>(words.length);
        for (int i = 0;i< words.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j<words[i].length(); j++) {
                sb.append(mores[words[i].charAt(j) - 'a']);
            }
            result.add(sb.toString());
        }
        return result.size();
    }
}
