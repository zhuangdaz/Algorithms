package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/17/16.
 */

/**
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {
    public class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode start = new ListNode(0);
            start.next = head;
            ListNode n = start;

            while (n.next != null) {
                if (n.next.val == val) {
                    n.next = n.next.next;
                } else {
                    n = n.next;
                }
            }
            return start.next;
        }
    }
}
