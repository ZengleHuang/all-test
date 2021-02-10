package com.spring13269.leetcode.Q101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.spring13269.leetcode.base.TreeNode;

/**
 * Q113
 *
 * @author : zengle.huang@hand-china.com 2020/9/26
 */
public class Q113 {
    /**
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        this.sum = sum;
        count(new ArrayList<>(), root, 0);

        return result;
    }
    int sum;
    List<List<Integer>> result = new ArrayList<>();

    public void count(List<Integer> list, TreeNode node, int count) {
        if (node == null) {
            return;
        }
        if (node.left != null || node.right !=null) {
            count += node.val;
            list.add(node.val);
            count(list, node.left, count);
            count(list, node.right, count);
            list.remove(list.size()-1);
        } else if (count+node.val == sum) {
            //list.add(node.val);
            list.forEach(System.out::print);
            System.out.println("find==");
            List<Integer> chi1 = new ArrayList<>(list);
            chi1.forEach(System.out::print);
            System.out.println("find==111");
            chi1.add(node.val);
            result.add(chi1);

            result.forEach(System.out::print);
            System.out.println("find==2222");
        }
    }
}
