package com.spring13269.leetcode.Q101_200;

import java.util.ArrayList;
import java.util.List;

import com.spring13269.leetcode.base.TreeNode;

/**
 * Q144
 *
 * @author : zengle.huang@hand-china.com 2020/10/27
 */
public class Q144 {
    /**
     * 给定一个二叉树，返回它的 前序 遍历。
     *  示例:
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     * 输出: [1,2,3]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */
    List<Integer> result = new ArrayList<>(100);
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        preorder(root);
        return result;
    }
    public void preorder(TreeNode node) {
        if (node == null) {
            return;
        } else {
            result.add(node.val);
            preorder(node.left);
            preorder(node.right);
        }
    }
}
