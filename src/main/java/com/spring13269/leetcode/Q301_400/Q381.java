package com.spring13269.leetcode.Q301_400;

import java.util.*;

/**
 * Q381
 *
 * @author : zengle.huang@hand-china.com 2020/10/31
 */
public class Q381 {
    /**
     * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
     * 注意: 允许出现重复元素。
     * insert(val)：向集合中插入元素 val。
     * remove(val)：当 val 存在时，从集合中移除一个 val。
     * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
     * 示例:
     * // 初始化一个空的集合。
     * RandomizedCollection collection = new RandomizedCollection();
     * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
     * collection.insert(1);
     * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
     * collection.insert(1);
     * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
     * collection.insert(2);
     * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
     * collection.getRandom();
     * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
     * collection.remove(1);
     * // getRandom 应有相同概率返回 1 和 2 。
     * collection.getRandom();
     */

    static class RandomizedCollection {
        public static void main(String[] args) {
            RandomizedCollection c = new RandomizedCollection();
            c.insert(0);
            c.insert(1);
            c.remove(0);
            c.insert(2);
            c.remove(1);
            c.getRandom();

        }
        Map<Integer, List<Integer>> valueMap;
        int count;
        Map<Integer, Integer> addressMap;
        Random random;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            valueMap = new HashMap<>();
            count = 0;
            addressMap = new HashMap<>();
            //allNode = new ArrayList<>();
            random = new Random();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            count++;
            addressMap.put(count, val);
            List<Integer> allAdd;
            boolean flag;
            if (valueMap.containsKey(val)) {
                allAdd = valueMap.get(val);
                flag = false;
            } else {
                allAdd = new ArrayList<>();
                flag = true;
            }
            allAdd.add(count);
            valueMap.put(val, allAdd);
            return flag;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            System.out.println("移除元素"+ val);
            if (!valueMap.containsKey(val)) {
                return false;
            }
            List<Integer> allAdd = valueMap.get(val);
            // 删除最后一个
            int last = allAdd.size()-1;
            // 获取最后一位的地址
            int address = allAdd.get(last);
            System.out.println("移除元素最后一位地址"+ address);
            // 移除list中最后一位
            allAdd.remove(last);
            if (allAdd.size() < 1) {
                valueMap.remove(val);
            } else {
                valueMap.put(val, allAdd);
            }
            // 记录所有位置信息的map最后一位移至删除的元素的位置
            int addLast = addressMap.get(count);
            if (count != address) {
                addressMap.put(address, addLast);
                //resize
                List<Integer> newL = valueMap.get(addLast);
                newL.set(newL.size()-1, address);
                newL.sort(Integer::compareTo);
                valueMap.put(addLast, newL);
            }
            addressMap.remove(count);
            count--;
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            if (count < 1) {
                return 0;
            }
            int ran = random.nextInt(count) +1;
            System.out.println("random 获取" + ran + " 值" + addressMap.get(ran));
            return addressMap.get(ran);
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
