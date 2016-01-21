package com.betterman.algorithms.leetcode.hard;

import com.betterman.algorithms.leetcode.common.ListNode;

import java.util.Arrays;

/**
 * Created by zhuangda on 1/20/16.
 */
public class MergeKSortedLists {
    public class Solution {
        //O(nlogk)
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return null;
            else if (lists.length == 1) return lists[0];
            else if (lists.length == 2) return mergeTwoSortedList(lists[0], lists[1]);
            else return mergeTwoSortedList(mergeKLists(Arrays.copyOfRange(lists, 0, lists.length / 2)),
                    mergeKLists(Arrays.copyOfRange(lists, lists.length / 2, lists.length)));

        }

        private ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
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
    }
}
