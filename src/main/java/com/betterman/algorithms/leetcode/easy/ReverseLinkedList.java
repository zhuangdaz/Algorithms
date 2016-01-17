package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/16/16.
 */
public class ReverseLinkedList {
    public class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode n = head;
            ListNode prev = null;
            while(n != null) {
                ListNode next = n.next;
                n.next = prev;
                prev = n;
                n = next;
            }
            return prev;
        }


        public ListNode reverseListRecursive(ListNode head) {
            return helper(head, null);
        }

        private ListNode helper(ListNode n, ListNode prev) {
            if (n == null) {
                return prev;
            }

            ListNode next = n.next;
            n.next = prev;
            return helper(next, n);
        }
    }
}
