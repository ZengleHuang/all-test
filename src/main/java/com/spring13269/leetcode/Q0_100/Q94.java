package com.spring13269.leetcode.Q0_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.spring13269.leetcode.base.TreeNode;

/**
 * Q94
 *
 * @author : zengle.huang@hand-china.com 2020/9/14
 */
public class Q94 {
    /**
     * 给定一个二叉树，返回它的中序 遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,3,2]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(result, root);
        return result;
    }

    public void inorder(List<Integer> result, TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        inorder(result, node.left);
        result.add(node.val);
        inorder(result, node.right);
    }
}
