package com.spring13269.leetcode.Q101_200;

/**
 * Q117
 *
 * @author : zengle.huang@hand-china.com 2020/9/28
 */
public class Q117 {
    /**
     * 给定一个二叉树
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     * 进阶：
     * 你只能使用常量级额外空间。
     * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     */
    public Node connect(Node root) {
        connectRight(root);
        return root;
    }

    public void connectRight(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
                connectRight(root.left);
            } else if (root.next != null){
                boolean notFound = true;
                Node next = root.next;
                while (notFound && next != null) {
                    if (next.left != null) {
                        root.left.next = next.left;
                        connectRight(root.left);
                        notFound = false;
                    } else if (next.right != null) {
                        root.left.next = next.right;
                        connectRight(root.left);
                        notFound = false;
                    } else {
                        next = next.next;
                    }
                }
            }
        }
        if (root.right != null){
            boolean notFound = true;
            Node next = root.next;
            if (next != null) {
            while (notFound && next != null) {
                if (next.left != null) {
                    root.right.next = next.left;
                    connectRight(root.right);
                    notFound = false;
                } else if (root.next.right != null) {
                    root.right.next = next.right;
                    connectRight(root.right);
                    notFound = false;
                }else {
                    next = next.next;
                }
            }} else
            {
                connectRight(root.right);
            }
        }
    }


    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
