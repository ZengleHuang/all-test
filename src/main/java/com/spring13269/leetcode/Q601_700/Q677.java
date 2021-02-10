package com.spring13269.leetcode.Q601_700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Q677 description
 *
 * @author zengle.huang@hand-china.com  2019/12/27
 * @version 1.0
 */
public class Q677 {
    /**
     * 实现一个 MapSum 类里的两个方法，insert 和 sum。
     *
     * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
     *
     * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
     *
     */
    static class MapSum {

        List<Node> nums = null;
        /** Initialize your data structure here. */
        public MapSum() {
            nums = new ArrayList<>();
        }

        public void insert(String key, int val) {
            if (key.isEmpty()) {
                return;
            }
            Node node = MapSum.contains(nums, key.charAt(0));
            if (node == null) {
                Node newN = Node.addChild(key.toCharArray(), val);
                nums.add(newN);
            } else {
                for (int i = 1; i< key.length(); i++) {
                    Node child = MapSum.contains(node.getChild(), key.charAt(i));
                    if (child != null) {
                        node = child;
                        continue;
                    } else {
                        Node newN = Node.addChild(key.substring(i).toCharArray(), val);
                        node.addChild(newN);
                        return;
                    }
                }
                node.setValue(val);
            }
            System.out.println(nums.toString());
        }

        public int sum(String prefix) {
            Node node = MapSum.contains(nums, prefix.charAt(0));
            if (node == null) {
                return 0;
            }
            for (int i = 1; i< prefix.length(); i++) {
                Node child = MapSum.contains(node.getChild(), prefix.charAt(i));
                if (child != null) {
                    node = child;
                    continue;
                } else {
                    return 0;
                }
            }
            return node.nodeCount();
        }

        public static Node contains(List<Node> nodes, char c) {
            for (Node node: nodes) {
                if (node.getC() == c) {
                    return node;
                }
            }
            return null;
        }
    }


    static class Node{
        private int value = 0;
        private char c;
        List<Node> child = new ArrayList<>();

        public Node(char c) {
            this.c = c;
        }
        public Node(char c, int value) {
            this.value = value;
            this.c = c;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public int getValue() {
            return this.value;
        }
        public char getC() {
            return this.c;
        }
        public List<Node> getChild() {
            return this.child;
        }

        public int nodeCount() {
            int count = this.value;
            for (Node node:this.child) {
                count+=node.nodeCount();
            }
            return count;
        }

        public static Node addChild(char[] others, int value) {
            Node child = new Node(others[others.length -1], value);
            for (int i = others.length -2; i >=0; i--) {
                Node p = new Node(others[i]);
                p.addChild(child);
                child = p;
            }
            return child;
        }

        private void addChild(Node child) {
            this.child.add(child);
        }

        @Override
        public String toString() {
            return "char:" + c + " value:" + value + " child:[" + child.toString() + "]";
        }
    }





    //------------------------------------------------------------

    /**
     *
     * 直接使用map 和contains
     */
    /*class MapSum {

        Map<String, Integer> nums = null;
        *//** Initialize your data structure here. *//*
        public MapSum() {
            nums = new HashMap<>();
        }

        public void insert(String key, int val) {
            nums.put(key, val);
        }

        public int sum(String prefix) {
            return nums.entrySet().stream()
                    .filter(entry -> entry.getKey().startsWith(prefix))
                    .map(Map.Entry::getValue)
                    .reduce(0, Integer::sum);
        }
    }
*/
}
