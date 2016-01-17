package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/17/16.
 */
public class RemoveDuplicatesFromSortedList {
    public class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode n = head;
            while(n != null) {
                while(n.next != null && n.val == n.next.val) {
                    n.next = n.next.next;
                }
                n = n.next;
            }
            return head;
        }
    }
}
