package com.spring13269.leetcode.Q0_100;

import com.spring13269.leetcode.base.ListNode;

/**
 * Q19
 *
 * @author : zengle.huang@hand-china.com 2020/10/18
 */
public class Q19 {
    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     * 你能尝试使用一趟扫描实现吗？
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        if (n >= count) {
            return head.next;
        } else {
            cur = head;
            for (int i = 1; i < count - n; i++) {
                cur=cur.next;
            }
            if (cur.next != null) {
                cur.next = cur.next.next;
            }
        }
        return head;
    }
}
