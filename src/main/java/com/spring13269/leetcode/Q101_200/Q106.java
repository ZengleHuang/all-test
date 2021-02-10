package com.spring13269.leetcode.Q101_200;

import java.util.Arrays;

import sun.reflect.generics.tree.Tree;

import com.spring13269.leetcode.base.TreeNode;

/**
 * Q106
 *
 * @author : zengle.huang@hand-china.com 2020/9/25
 */
public class Q106 {
    /**
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        if (inorder.length != postorder.length) {
            return null;
        }
        TreeNode parent = new TreeNode(postorder[postorder.length-1]);
        for (int i =0;i<inorder.length; i++) {
            if (inorder[i] == parent.val) {
                TreeNode left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
                parent.left = left;
                TreeNode right = buildTree(Arrays.copyOfRange(inorder, i+1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length-1));
                parent.right = right;
                return parent;
            }
        }
        return parent;

    }
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        if (inorder.length != postorder.length) {
            return null;
        }
        this.inorder = inorder;
        this.postorder = postorder;
        // 左节点
        TreeNode result = null;
        int start = 0;
        TreeNode node = buildNode(start, inorder.length);
        result = node;
        while (point<inorder.length) {
            result = buildNode(point, inorder.length);
            result.left = node;
            node = result;
        }
        return result;
    }


    int[] inorder = null;
    int[] postorder = null;
    int point = 0;
    public TreeNode buildNode(int start, int end) {
        if (start >= inorder.length) {
            return null;
        }
        TreeNode leftNode =null;
        if (inorder[start] == postorder[start]) {
            new TreeNode(inorder[start]);
            point++;
            start++;
        }
        int parVal = inorder[start];
        TreeNode parNode = new TreeNode(inorder[start]);
        start++;
        point++;
        parNode.left = leftNode;
        for (int i = start; i< postorder.length && i < end; i++) {
            if (parVal == postorder[i]) {
                parNode.right = buildNode(start, i);
                point=i;
                break;
            }
        }
        System.out.println(parVal);
        return parNode;
    }

    public static void main(String[] args) {
        Q106 q = new Q106();
        TreeNode node = q.buildTree(new int[] {9,3,15,20,7}, new int[]{9,15,7,20,3});
        System.out.println(node.val);
    }

}
