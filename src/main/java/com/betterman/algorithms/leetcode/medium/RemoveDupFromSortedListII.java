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
            ListNode prev = start, curr = head;

            while (curr != null) {
                //dup
                if (curr.next != null && curr.val == curr.next.val) {
                    int dup = curr.val;
                    while (curr != null && curr.val == dup) {
                        curr = curr.next;
                    }
                    prev.next = curr;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
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
