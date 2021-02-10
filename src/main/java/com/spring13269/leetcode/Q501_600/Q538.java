package com.spring13269.leetcode.Q501_600;

import java.util.List;

import com.spring13269.leetcode.base.TreeNode;

/**
 * Q538
 *
 * @author : zengle.huang@hand-china.com 2020/9/21
 */
public class Q538 {
    /**
     * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
     *
     *  二叉搜索树   用前序搜索
     *
     * 例如：
     *
     * 输入: 原始二叉搜索树:
     *               5
     *             /   \
     *            2     13
     *
     * 输出: 转换为累加树:
     *              18
     *             /   \
     *           20     13
     *
     */

    int count = 0;
    public TreeNode convertBST(TreeNode root) {
        count(root);
        System.out.println(count);
        substrb(root);

        return root;
    }

    public void count(TreeNode node) {
        if (node != null) {
            System.out.println(count);
            count+=node.val;
            count(node.left);
            count(node.right);
        }
    }

    public void substrb(TreeNode node) {
        if (node != null) {
            substrb(node.left);
            int val = node.val;
            node.val = count;
            count-=val;
            substrb(node.right);

        }
    }
}
