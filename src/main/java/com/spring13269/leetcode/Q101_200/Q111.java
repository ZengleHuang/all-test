package com.spring13269.leetcode.Q101_200;

import java.util.Objects;
import java.util.Stack;

import com.spring13269.leetcode.base.TreeNode;

/**
 * Q111
 *
 * @author : zengle.huang@hand-china.com 2020/8/21
 */
public class Q111 {
    /**
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明: 叶子节点是指没有子节点的节点。
     * 示例:
     *
     * 给定二叉树 [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最小深度  2.
     */

    public int minDepth(TreeNode root) {
        int depth = 1;
        if (root.getLeft() == null && root.getRight() == null) {
            return depth;
        }
        return getNodeDepth(depth, root);
        /*while (true) {
            depth++;
            TreeNode left = root.getLeft();
            TreeNode right = root.getRight();
            if (Objects.nonNull(left)) {
                if (Objects.isNull(left.getLeft()) && Objects.isNull(left.getRight())) {
                    return depth;
                }
            }
            if (Objects.nonNull(right)) {
                if (Objects.isNull(right.getLeft()) && Objects.isNull(right.getRight())) {
                    return depth;
                }
            }
        }*/
    }
    public int getNodeDepth(int depth, TreeNode node) {
        if (Objects.isNull(node)) {
            return Integer.MAX_VALUE;
        }
        if (Objects.isNull(node.getLeft()) && Objects.isNull(node.getRight())) {
            return depth;
        }
        depth++;
        return Math.min(getNodeDepth(depth, node.getLeft()), getNodeDepth(depth, node.getRight()));
    }
}
