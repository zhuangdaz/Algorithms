package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/20/16.
 */
public class InsertionSortList {
    public class Solution {
        public ListNode insertionSortList(ListNode head) {
            ListNode dummy = new ListNode(0);

            while (head != null) {
                ListNode next = head.next;

                ListNode curr = dummy;
                while (curr.next != null && curr.next.val < head.val) {
                    curr = curr.next;
                }

                ListNode tmp = curr.next;
                curr.next = head;
                head.next = tmp;
                head = next;
            }

            return dummy.next;
        }
    }
}
