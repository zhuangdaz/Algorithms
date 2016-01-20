package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/20/16.
 */
public class ReorderList {
    public class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) return;
            ListNode slow = head, fast = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            ListNode reversed = reverse(slow.next);
            slow.next = null;

            while (reversed != null) {
                ListNode reversedNext = reversed.next;

                reversed.next = head.next;
                head.next = reversed;
                head = reversed.next;
                reversed = reversedNext;
            }
        }

        ListNode reverse(ListNode head) {
            ListNode newHead = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
            }
            return newHead;
        }
    }
}
