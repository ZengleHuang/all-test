package com.spring13269.leetcode.Q501_600;

import java.util.ArrayList;
import java.util.List;

import com.spring13269.leetcode.base.TreeNode;

/**
 * Q530
 *
 * @author : zengle.huang@hand-china.com 2020/10/12
 */
public class Q530 {
    /**
     * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     *
     *  
     *
     * 示例：
     *
     * 输入：
     *
     *    1
     *     \
     *      3
     *     /
     *    2
     *
     * 输出：
     * 1
     *
     * 解释：
     * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
     *  
     *
     * 提示：
     *
     * 树中至少有 2 个节点。
     * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> treeList = new ArrayList<>();
        getTree(treeList, root);
        int min = Integer.MAX_VALUE;
        for (int i =1; i< treeList.size(); i++) {
            min = Math.min(min, treeList.get(i) - treeList.get(i-1));
        }
        return min;
    }

    public void getTree(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        getTree(list, node.left);
        list.add(node.val);
        getTree(list, node.right);
    }
}
