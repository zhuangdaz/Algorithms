package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/17/16.
 */
public class PalindromeLinkedList {
    public class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true;

            ListNode slow = head;
            ListNode fast = head.next;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            if (fast.next != null) {
                fast = slow.next.next;
                slow = slow.next;
            } else {
                fast = slow.next;
            }

            ListNode reversedHead = reverse(fast);
            ListNode forward = head;
            ListNode back = reversedHead;
            boolean res;
            while (back != null && forward.val == back.val) {
                forward = forward.next;
                back = back.next;
            }

            res = back == null;
            reversedHead = reverse(reversedHead);
            slow.next = reversedHead;
            return res;
        }

        private ListNode reverse(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }
}
