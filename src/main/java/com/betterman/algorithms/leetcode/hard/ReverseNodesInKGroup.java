package com.betterman.algorithms.leetcode.hard;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/21/16.
 */
public class ReverseNodesInKGroup {
    public class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k <= 1 || head == null || head.next == null) return head;
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode pre = dummy, curr = pre.next;
            ListNode subHead, then;
            int i = 0;
            while (curr != null) {
                i++;

                if (i == k) {
                    subHead = pre.next;
                    then = curr.next;

                    curr.next = null;
                    pre.next = reverse(subHead);
                    pre = subHead;
                    pre.next = then;
                    curr = then;
                    i = 0;
                } else {
                    curr = curr.next;
                }
            }

            return dummy.next;
        }


        private ListNode reverse(ListNode head) {
            ListNode newHead = null;

            while (head != null) {
                ListNode then = head.next;
                head.next = newHead;
                newHead = head;
                head = then;
            }
            return newHead;
        }
    }
}
