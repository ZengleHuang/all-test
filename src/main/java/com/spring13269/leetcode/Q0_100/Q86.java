package com.spring13269.leetcode.Q0_100;

import java.util.List;

import com.spring13269.leetcode.base.ListNode;

/**
 * Q86
 *
 * @author : zengle.huang@hand-china.com 2021/1/4
 */
public class Q86 {
    /**
     * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
     * 你应当保留两个分区中每个节点的初始相对位置。
     *  
     * 示例：
     * 输入：head = 1->4->3->2->5->2, x = 3
     * 输出：1->2->2->4->3->5
     */
    public ListNode partition(ListNode head, int x) {
        ListNode start = new ListNode(-1);
        /*start.next = head;
        ListNode slow = start;
        ListNode fast = start;
        while (fast.next != null) {
            ListNode fastNext = fast.next;
            if (fast.next.val < x) {
                ListNode slowNext = slow.next;
                slow.next = fast.next;
                slow.next.next = slowNext;
                slow = slow.next;
                fast.next.next = fastNext.next;
                fast = fastNext;
            } else {
                fast = fastNext;
            }
            start.print();
        }*/
        ListNode bigger = new ListNode(-1);
        ListNode sflow = start;
        ListNode bflow = bigger;
        while (head != null) {
            if (head.val < x) {
                sflow.next = head;
                sflow = sflow.next;
            } else {
                bflow.next = head;
                bflow = bflow.next;
            }
            head = head.next;
        }
        sflow.next = null;
        bflow.next = null;
        sflow.next = bigger.next;
        start.print();
        return start.next;
    }

    public static void main(String[] args) {
        ListNode c = ListNode.init(new int[]{2,1,4,3,2,5,2});
        Q86 q = new Q86();
        q.partition(c, 3);

    }
}
