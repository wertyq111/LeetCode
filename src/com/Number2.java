package com;

import java.util.List;

/**
 * @author zhouxufeng
 * @version 1.0
 * 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
@SuppressWarnings({"all"})
public class Number2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int curSum = l1.val + l2.val;
        int overflow = 0;

        ListNode sums = new ListNode(0);

        ListNode tempSums = sums;
        while(l1 != null) {
            int l1Val = l1.val;
            int l2Val = 0;
            if(l2 != null) {
                l2Val = l2.val;
            }
            int tempVal = l1Val + l2Val + overflow;
            overflow = tempVal / 10;
            tempVal = tempVal % 10;
            tempSums.next = new ListNode(tempVal);
            tempSums = tempSums.next;
            //如果 l1.next 为 null 但是 l2.next 不为 null ,l2.next转移给l1,l2.next 设置为 0
            if(l1.next == null && l2 != null && l2.next != null) {
                l1 = l2.next;
                l2 = new ListNode(0);
            } else {
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        if(overflow > 0) {
            tempSums = new ListNode(overflow);
        }

        return sums.next;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}