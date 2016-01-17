package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/17/16.
 */

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public ListNode removeNthFromEnd(ListNode head, int nth) {
            ListNode start = new ListNode(0);
            start.next = head;

            ListNode slow = start, fast = start;

            while (nth-- >= 0) {
                fast = fast.next;
            }


            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow.next.next;
            return start.next;
        }
    }
}
