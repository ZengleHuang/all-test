package com.spring13269.leetcode.Q1101_1200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Q1122
 *
 * @author : zengle.huang@hand-china.com 2020/11/14
 */
public class Q1122 {
    /**
     * 给你两个数组，arr1 和 arr2，
     * arr2 中的元素各不相同
     * arr2 中的每个元素都出现在 arr1 中
     * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
     *
     * 示例：
     * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * 输出：[2,2,2,1,4,3,3,9,6,7,19]
     *  
     * 提示：
     * arr1.length, arr2.length <= 1000
     * 0 <= arr1[i], arr2[i] <= 1000
     * arr2 中的元素 arr2[i] 各不相同
     * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] inArr2 = new int[arr2.length];
        int[] notInArr2 = new int[1001];
        Map<Integer, Integer> arr2Set = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            arr2Set.put(arr2[i], i);
        }
        for (int i : arr1) {
            if (arr2Set.containsKey(i)) {
                inArr2[arr2Set.get(i)]++;
            } else {
                notInArr2[i] ++;
            }
        }
        int[] result = new int[arr1.length];
        int resultI = 0;
        for (int i = 0; i < inArr2.length; i++) {
            if (inArr2[i] > 0) {
                result[resultI] = arr2[i];
                inArr2[i]--;
                i --;
                resultI++;
            }
        }
        for (int i = 0; i < notInArr2.length; i++) {
            if (notInArr2[i] > 0) {
                result[resultI] = i;
                notInArr2[i]--;
                i --;
                resultI++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q1122 q = new Q1122();
        q.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19},
                new int[]{2,1,4,3,9,6});
    }
}
