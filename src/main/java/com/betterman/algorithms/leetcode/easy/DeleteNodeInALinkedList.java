package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/17/16.
 */
public class DeleteNodeInALinkedList {
    public class Solution {
        public void deleteNode(ListNode node) {
            if (node == null) return;

            if (node.next != null) {
                node.val = node.next.val;
                node.next = node.next.next;
            }
        }
    }
}
