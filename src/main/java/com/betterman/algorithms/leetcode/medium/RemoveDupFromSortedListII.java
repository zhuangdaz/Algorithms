package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/17/16.
 */
public class RemoveDupFromSortedListII {
    public class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode start = new ListNode(0);
            start.next = head;
            ListNode prev = start;

            while (head != null) {
                //dup
                if (head.next != null && head.val == head.next.val) {
                    while (head.next != null && head.val == head.next.val) {
                        head = head.next;
                    }
                } else {
                    prev.next = head;
                    prev = head;
                }
                head = head.next;
            }
            prev.next = null;
            return start.next;
        }

        public ListNode deleteDuplicatesRec(ListNode head) {
            if (head == null) {
                return null;
            } else if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                return deleteDuplicatesRec(head.next);
            } else {
                head.next = deleteDuplicatesRec(head.next);
                return head;
            }
        }
    }
}
