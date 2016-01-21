package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/20/16.
 */
public class RotateList {
    public class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) return head;
            ListNode n = head;
            int len = 0;
            while (n != null) {
                len++;
                n = n.next;
            }

            k = k % len;

            ListNode p1 = head, p2 = head;
            while (k-- > 0) {
                p2 = p2.next;
            }

            while (p2.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }

            p2.next = head;
            ListNode res = p1.next;
            p1.next = null;
            return res;
        }
    }
}
