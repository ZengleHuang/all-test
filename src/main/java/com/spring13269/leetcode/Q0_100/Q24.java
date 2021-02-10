package com.spring13269.leetcode.Q0_100;

import com.spring13269.leetcode.base.ListNode;

/**
 * Q24
 *
 * @author : zengle.huang@hand-china.com 2020/10/13
 */
public class Q24 {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例:
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    public ListNode swapPairs(ListNode head) {
        ListNode pre = null, current = null;
        while (head != null && head.next != null) {
            ListNode f1 = new ListNode(head.next.val);
            if (pre == null) {
                pre = f1;
                current = pre;
            } else {
                current.next = f1;
                current = current.next;
            }
            ListNode f2 = new ListNode(head.val);
            current.next = f2;
            current = current.next;
            head = head.next.next;
        }
        if (head != null) {
            if (current == null) {
                return new ListNode(head.val);
            }
            current.next = new ListNode(head.val);
        }
        return pre;
    }
}
