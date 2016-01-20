package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/19/16.
 */
public class ReverseLinkedListII {
    public class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;

            for (int i = 0; i < m - 1; i++) {
                pre = pre.next;
            }

            ListNode p1 = pre.next;
            ListNode p2 = p1.next;

            for (int i = 0; i < n - m; i++) {
                p1.next = p2.next;
                p2.next = pre.next;
                pre.next = p2;
                p2 = p1.next;
            }

            return dummy.next;
        }
    }
}
