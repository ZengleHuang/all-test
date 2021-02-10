package com.spring13269.leetcode.base;

//import lombok.Data;
//import lombok.Getter;

import java.util.Objects;

/**
 * ListNode description
 *
 * @author zengle.huang@hand-china.com  2020/2/25
 * @version 1.0
 */
//@Data
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode(){
    }

    public void print() {
        if (Objects.isNull(next)) {
            System.out.println(val);
        } else {
            System.out.print(val + "->");
            next.print();
        }
    }

    public static ListNode init(int[] args) {
        if (args.length < 1) {
            return new ListNode();
        }
        ListNode first = new ListNode(args[0]);
        ListNode step = first;
        for (int i = 1; i < args.length; i++) {
            step.next = new ListNode(args[i]);
            step = step.next;
        }
        return first;
    }
}
