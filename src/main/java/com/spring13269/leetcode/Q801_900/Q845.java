package com.spring13269.leetcode.Q801_900;

/**
 * Q845
 *
 * @author : zengle.huang@hand-china.com 2020/10/25
 */
public class Q845 {
    /**
     * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
     * B.length >= 3
     * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
     * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
     * 给出一个整数数组 A，返回最长 “山脉” 的长度。
     * 如果不含有 “山脉” 则返回 0。
     *  
     * 示例 1：
     * 输入：[2,1,4,7,3,2,5]
     * 输出：5
     * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
     * 示例 2：
     * 输入：[2,2,2]
     * 输出：0
     * 解释：不含 “山脉”。
     *  
     * 提示：
     * 0 <= A.length <= 10000
     * 0 <= A[i] <= 10000
     */
    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int maxLength = 0;
        int currentLength = 0;
        boolean isUp = false;
        for (int i = 0; i < A.length - 1; i++) {
            int curr = A[i];
            int next = A[i+1];
            if (curr == next) {
                if (!isUp && currentLength >= 2) {
                    currentLength++;
                    maxLength = Math.max(maxLength, currentLength);
                }
                isUp = false;
                currentLength = 0;
                continue;
                //currentLength ++;
            }
            if (isUp) {
                if (curr < next) {
                    currentLength++;
                } else if (curr > A[i+1]) {
                    isUp = false;
                    currentLength++;
                }
            } else {
                if (curr < next) {
                    isUp = true;
                    currentLength++;
                    if (currentLength >= 3) {
                        maxLength = Math.max(maxLength, currentLength);
                        currentLength = 1;
                    }
                } else if (currentLength >= 2) {
                    currentLength++;
                }
            }
        }
        if (!isUp && currentLength >= 2 && A[A.length -1] < A[A.length-2]) {
            currentLength++;
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Q845 q = new Q845();
        System.out.println(q.longestMountain(new int[]{1,2,3,2,3,2,3,2,3,2,3,2,3,2,3,2,1,0}));
    }
}
