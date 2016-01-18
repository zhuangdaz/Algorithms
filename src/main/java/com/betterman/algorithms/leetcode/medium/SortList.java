package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/18/16.
 */
public class SortList {
    public class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode slow = head, fast = head.next;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            ListNode h2 = sortList(slow.next);
            slow.next = null;
            ListNode h1 = sortList(head);
            return merge(h1, h2);
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode start = new ListNode(0);
            ListNode n = start;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    n.next = l1;
                    l1 = l1.next;
                } else {
                    n.next = l2;
                    l2 = l2.next;
                }
                n = n.next;
            }

            if (l1 != null) n.next = l1;
            else if (l2 != null) n.next = l2;
            return start.next;
        }
    }
}
