package com.spring13269.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * MaxNumber321 description
 *
 * @author zengle.huang@hand-china.com  2019/11/25
 * @version 1.0
 */
public class MaxNumber321 {

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (k == 0) {
            return new int[]{};
        }
        if (nums1.length == 0 && nums2.length == 1) {
            return nums2;
        } else if (nums2.length == 0 && nums1.length == 1) {
            return nums1;
        }
        Map<Integer, Integer[]> position = new HashMap<Integer, Integer[]>(10);
        int[] result = new int[k];
        for (int i = 0; i < nums1.length; i++) {
            Integer[] list = position.getOrDefault(nums1[i], new Integer[2]);//[nums1[i]];
            if (list[0] == null) {
                list[0] = i;
                position.put(nums1[i], list);
            }
            //list.add(i);
        }
        for (int i = 0; i < nums2.length; i++) {
            //List<Integer> list = position.getOrDefault(nums2[i], new LinkedList<>());//[nums2[i]];
            Integer[] list = position.getOrDefault(nums2[i], new Integer[2]);//[nums1[i]];
            if (list[1] == null) {
                list[1] = nums1.length + i;
                position.put(nums2[i], list);
            }
            // nums2 放在nums1 之后
            //list.add(nums1.length + i);
        }

        for (int i = 9; i >= 0; i --) {
            Integer[] list = position.get(i);
            //List<Integer> list = position.get(i);//position[i];
            if (list == null || list.length == 0) {
                continue;
                // 最大不存在，继续找下个最大数
            } else {
                int[] child = null;
                for (Integer integer : list) {
                    if (integer == null) {
                        continue;
                    }
                    int lPoints = 0;
                    if (integer >= nums1.length) {
                        lPoints = nums2.length - (integer - nums1.length + 1) + nums1.length;
                    } else {
                        lPoints = nums1.length - integer - 1 + nums2.length;
                    }
                    // 剩余节点少于个数
                    if (lPoints < k - 1) {
                        continue;
                    }
                    result[0] = i;
                    int[] newChild = maxNumber(Arrays.copyOfRange(nums1, integer >= nums1.length ? 0 : (integer + 1),nums1.length),
                            Arrays.copyOfRange(nums2, integer >= nums1.length ?(integer - nums1.length + 1):0 ,nums2.length),
                            k -1);
                    if (child == null) {
                        child = newChild;
                    } else {
                        //找到最大子对象
                        for (int step = 0; step < child.length; step++) {
                            if (child[step] < newChild[step]) {
                                child = newChild;
                                break;
                            } else if (child[step] > newChild[step]){
                                break;
                            }
                        }
                    }
                }

                for (int step = 0; child != null && step < child.length; step++) {
                    result[step + 1] = child[step];
                }
                if (child != null && result[0] != 0) {
                    return result;
                }
            }
        }
        return result;
    }

    public static int[] maxNumber(int[] nums1, int k) throws Exception {
        if (k > nums1.length) {
            throw new Exception("数据不够");
        }
        if (k == nums1.length) {
            return nums1;
        }
        int maxIndex = 0;
        // 选从0 到 k之前最大的值
        for (int i = 1; i <= nums1.length - k; i ++) {
            if (nums1[i] > nums1[maxIndex]) {
                maxIndex = i;
            }
        }
        int[] result = new int[k];
        result[0] = nums1[maxIndex];
        int[] child = maxNumber(Arrays.copyOfRange(nums1, maxIndex +1, nums1.length), k - 1);
        for (int i = 0; i < child.length; i++) {
            result[i+1] = child[i];
        }
        return result;
    }
/*
    public static int[] buildArray(int[] nums1, int[] nums2) {
        // nums1 和nums2的游标
        int[] result = new int[nums1.length + nums2.length];
        int i = 0,j = 0;
        for (int k = 0; k < result.length; k++) {
            if (i >= nums1.length) {
                result[k] = nums2[j];
                j ++;
                continue;
            }
            if (j >= nums2.length) {
                result[k] = nums1[i];
                i ++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                result[k] = nums2[j];
                j ++;
            } else if (nums1[i] > nums2[j]) {
                result[k] = nums1[i];
                i ++;
            } else if (nums1[i] == nums2[j]) {
                // 比较下一位
                for (int m = 1; ; m++) {
                    // 有一个直到结尾都和另一个一样
                    if (i + m >= nums1.length || nums1[i+m] <= nums2[j+m]) {
                        result[k] = nums2[j];
                        j ++;
                        break;
                    }
                    if (j + m >= nums2.length || nums1[i+m] >= nums2[j+m]) {
                        result[k] = nums1[i];
                        i ++;
                        break;
                    }
                }
            }
        }
        return result;
    }*/

    public static void main(String[] args) throws Exception {
        /*[3,4,6,5]
[9,1,2,5,8,3]
        5*/
        /*
        * [4,6,9,1,0,6,3,1,5,2,8,3,8,8,4,7,2,0,7,1,9,9,0,1,5,9,3,9,3,9,7,3,0,8,1,0,9,1,6,8,8,4,4,5,7,5,2,8,2,7,7,7,4,8,5,0,9,6,9,2]
[9,9,4,5,1,2,0,9,3,4,6,3,0,9,2,8,8,2,4,8,6,5,4,4,2,9,5,0,7,3,7,5,9,6,6,8,8,0,2,4,2,2,1,6,6,5,3,6,2,9,6,4,5,9,7,8,0,7,2,3]
60
        * */
        /*int[] nums1 = new int[]{4,6,9,1,0,6,3,1,5,2,8,3,8,8,4,7,2,0,7,1,9,9,0,1,5,9,3,9,3,9,7,3,0,8,1,0,9,1,6,8,8,4,4,5,7,5,2,8,2,7,7,7,4,8,5,0,9,6,9,2};
        int[] nums2 = new int[]{9,9,4,5,1,2,0,9,3,4,6,3,0,9,2,8,8,2,4,8,6,5,4,4,2,9,5,0,7,3,7,5,9,6,6,8,8,0,2,4,2,2,1,6,6,5,3,6,2,9,6,4,5,9,7,8,0,7,2,3};
          60
         */
        int[] nums1 = new int[]{5,6,8};
        int[] nums2 = new int[]{6,4,0};
        /*System.out.println(Arrays.toString(buildArray(nums1, nums2)));
        System.out.println(Arrays.toString(maxNumber(new int[]{6,7,6,0,4}, 4)));
*/
        System.out.println(Arrays.toString(maxNumber(nums1,nums2, 3)));
    }

}
