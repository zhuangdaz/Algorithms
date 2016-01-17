package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/17/16.
 */
public class OddEvenLinkedList {
    public class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) return null;
            ListNode odd = head, ehead = head.next, even = head.next;
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                odd = odd.next;

                even.next = even.next.next;
                even = even.next;
            }

            odd.next = ehead;
            return head;
        }
    }
}
