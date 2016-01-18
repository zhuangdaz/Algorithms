package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/18/16.
 */

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class PartitionList {
    public class Solution {
        // null
        // all less than x
        // all equal or greater than x
        // is the tail set to null?
        public ListNode partition(ListNode head, int x) {
            ListNode h1 = new ListNode(0);
            ListNode h2 = new ListNode(0);

            ListNode n1 = h1;
            ListNode n2 = h2;

            while (head != null) {
                if (head.val < x) {
                    n1.next = head;
                    n1 = n1.next;
                } else {
                    n2.next = head;
                    n2 = n2.next;
                }
                head = head.next;
            }
            n2.next = null;
            n1.next = h2.next;
            return h1.next;
        }
    }
}
