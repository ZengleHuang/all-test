package com.spring13269.leetcode.Q201_300;

import com.spring13269.leetcode.base.TreeNode;

/**
 * Q226
 *
 * @author : zengle.huang@hand-china.com 2020/9/16
 */
public class Q226 {
    /**
     * 翻转一棵二叉树。
     *
     * 示例：
     * 输入：
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 输出：
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * 备注:
     * 这个问题是受到 Max Howell 的 原问题 启发的 ：
     * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
     *
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null || root.right != null) {
            if (root.left != null) {
                invertTree(root.left);
            }
            if (root.right != null) {
                invertTree(root.right);
            }
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
        }
        return root;
    }
}
