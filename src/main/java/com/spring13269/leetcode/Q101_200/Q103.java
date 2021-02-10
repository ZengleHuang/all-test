package com.spring13269.leetcode.Q101_200;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

import com.spring13269.leetcode.base.TreeNode;

/**
 * Q103
 *
 * @author : zengle.huang@hand-china.com 2020/12/22
 */
public class Q103 {
    /**
     * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回锯齿形层序遍历如下：
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean flag = true;
        List<TreeNode> list = new ArrayList<>(2);
        List<List<Integer>> result = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            List<TreeNode> current = new ArrayList<>(list.size()*2);
            List<Integer> currentResult = new ArrayList<>(list.size());
            for (int i = 0; i < list.size(); i++) {
                currentResult.add(list.get(i).val);
                if (flag) {
                    if (Objects.nonNull(list.get(list.size() - i - 1).right)) {
                        current.add(list.get(list.size() - i - 1).right);
                    }
                    if (Objects.nonNull(list.get(list.size() - i - 1).left)) {
                        current.add(list.get(list.size() - i - 1).left);
                    }
                } else {
                    if (Objects.nonNull(list.get(list.size() - i - 1).left)) {
                        current.add(list.get(list.size() - i - 1).left);
                    }
                    if (Objects.nonNull(list.get(list.size() - i - 1).right)) {
                        current.add(list.get(list.size() - i - 1).right);
                    }
                }
            }
            flag = !flag;
            list = current;
            result.add(currentResult);
        }
        return result;
    }
}
