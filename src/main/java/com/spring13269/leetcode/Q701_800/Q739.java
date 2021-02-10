package com.spring13269.leetcode.Q701_800;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Q739 description
 *
 * @author zengle.huang@hand-china.com  2019/12/6
 * @version 1.0
 */
public class Q739 {
    public static int[] dailyTemperatures(int[] T) {
        // 用数组记录最大值列表， 从T 最后一位开始倒序 ，如果 第i位的数大于最大值列表里的第一个（最大），
        // 则替换最大的，最大值列表记录下标，如果小于最大值列表的
        int[] result = new int[T.length];
        int[] maxValues = new int[71];
        maxValues[0] = T.length - 1;
        for (int i = T.length-1; i >= 0; i--) {
            for (int j =0; ;j++) {
                if (maxValues[j] !=0 && T[i] >= T[maxValues[j]]) {
                    // 更改下标
                    maxValues[j] = i;
                    if (j+2<T.length) {maxValues[j+1] =0;}
                    if (j>0) {
                        result[i] = maxValues[j-1] - i;
                    }
                    break;
                } else if(maxValues[j]==0) {
                    maxValues[j] = i;
                    if (j+2<T.length) {maxValues[j+1] =0;}
                    break;
                } else if (T[i] < T[maxValues[j]]) {
                    result[i] = maxValues[j] - i;
                }
                System.out.println(Arrays.toString(maxValues));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //[3,1,1,4,3,1,1,3,1,1,1,1,30,1,3,2,1,25,2,1,19,2,1,3,2,1,11,5,1,1,2,1,3,2,1,2,1,2,1,3,2,1,0,46,3,1,1,1,30,18,5,1,1,2,1,12,1,10,5,1,2,1,1,4,3,1,1,11,1,1,8,1,1,5,1,3,1,1,11,1,3,2,1,1,5,3,2,1,1,0,1,0,3,2,1,0,0,2,1,0]
        int[] nums = new int[]{64,40,49,73,72,35,68,83,35,73,84,88,96,43,74,63,41,95,48,46,89,72,34,85,72,59,87,49,30,32,47,34,74,58,31,75,73,88,64,92,83,64,100,99,81,41,48,83,96,92,82,32,35,68,68,92,73,92,52,33,44,38,47,88,71,50,57,95,33,65,94,44,47,79,41,74,50,67,97,31,68,50,37,70,77,55,48,30,77,100,31,100,69,60,47,95,68,47,33,64};
        System.out.println(Arrays.toString(dailyTemperatures(nums)));
    }

    public static int[] dailyTemperatures1(int[] T) {
        Stack<Elem> stack = new Stack<>();
        int[] result = new int[T.length];
        for (int i=0;i<T.length;i++) {
            while (stack.size()>0 && stack.lastElement().getValue() < T[i]) {
                Elem elem = stack.pop();
                result[elem.getPosition()] = i - elem.getPosition();
            }
            stack.push(new Elem(T[i], i));
        }
        return result;
    }
    static class Elem{
        Integer value;
        Integer position;
        Elem(Integer value, Integer position) {
            this.value = value;
            this.position = position;
        }

        public Integer getValue() {
            return value;
        }

        public Integer getPosition() {
            return position;
        }
    }
}
