package com.spring13269.leetcode.Q301_400;

import com.spring13269.leetcode.base.ListNode;

/**
 * Q328
 *
 * @author : zengle.huang@hand-china.com 2020/11/13
 */
public class Q328 {
    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     *
     * 示例 1:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     *        1 2 3 4 5
     *        1 3 2 4 5
     * 示例 2:
     * 输入: 2->1->3->5->6->4->7->NULL
     * 输出: 2->3->6->7->1->5->4->NULL
     * 说明:
     * 应当保持奇数节点和偶数节点的相对顺序。
     * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
     */
    public ListNode oddEvenList(ListNode head) {
        changeList(head, head, head.next);
        return head;
    }
    public void changeList(ListNode head, ListNode slow, ListNode fast) {
        if (fast == null) {
            return;
        }
        if (fast.next == null) {

        }
        if (fast.next!=null) {

            ListNode slowNext = slow.next;
            slow.next = fast.next;
            fast.next = fast.next.next;
            slow.next.next = slowNext;
            head.print();
            /*
            ListNode fastNext = fast.next.next;
            ListNode slowNext = slow.next;
            slow.next = fast.next;
            slow.next.next = slowNext;
            fast.next = fastNext;*/
            changeList(head, slow.next, fast.next);
        }
    }

    public static void main(String[] args) {
        Q328 q = new Q328();
        q.oddEvenList(ListNode.init(new int[]{1,2,3,4,5,6,7,8,9}));
    }
}
