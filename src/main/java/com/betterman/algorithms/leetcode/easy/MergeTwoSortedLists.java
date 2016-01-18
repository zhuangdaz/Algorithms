package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/17/16.
 */

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    public class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

        public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            if (l1.val <= l2.val) {
                l1.next = mergeTwoListsRecursive(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoListsRecursive(l2.next, l1);
                return l2;
            }
        }
    }
}
