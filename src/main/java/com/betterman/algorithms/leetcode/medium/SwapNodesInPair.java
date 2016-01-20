package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/19/16.
 */
public class SwapNodesInPair {
    public class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode n = dummyHead;

            // n -> next -> next2 -> next3
            // n -> next2 -> next -> next3
            while (n != null && n.next != null && n.next.next != null) {
                ListNode next = n.next;
                ListNode next2 = n.next.next;
                ListNode next3 = n.next.next.next;

                n.next = next2;
                next2.next = next;
                next.next = next3;
                n = n.next.next;
            }
            return dummyHead.next;
        }
    }
}
