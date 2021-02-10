package com.spring13269.leetcode.Q501_600;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.text.html.parser.Entity;

import com.spring13269.leetcode.base.TreeNode;

/**
 * Q501
 *
 * @author : zengle.huang@hand-china.com 2020/9/24
 */
public class Q501 {
    /**
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     *
     * 假定 BST 有如下定义：
     *
     * 结点左子树中所含结点的值小于等于当前结点的值
     * 结点右子树中所含结点的值大于等于当前结点的值
     * 左子树和右子树都是二叉搜索树
     * 例如：
     * 给定 BST [1,null,2,2],
     *
     *    1
     *     \
     *      2
     *     /
     *    2
     * 返回[2].
     *
     * 提示：如果众数超过1个，不需考虑输出顺序
     *
     * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
     */

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> countMap = new HashMap<>();
        findChild(countMap, root);
        List<Map.Entry<Integer,Integer>> countList = countMap.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList());
        int[] result = new int[countList.size()];
        for (int i = 0; i < countList.size(); i++) {
            result[i] = countList.get(i).getKey();
        }
        return result;
    }
    public void findChild(Map<Integer, Integer> countMap, TreeNode node) {
        if (node == null) {
            return;
        }
        int count = countMap.getOrDefault(node.val, 0);
        countMap.put(node.val, ++count);
        findChild(countMap, node.left);
        findChild(countMap, node.right);
    }

}
