package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.ListNode;
import com.betterman.algorithms.leetcode.common.TreeNode;

/**
 * Created by zhuangda on 1/19/16.
 */
public class ConvertSortedListToBST {
    public class Solution {
        //O(nlgn)
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return new TreeNode(head.val);

            ListNode slow = head, fast = head.next.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            TreeNode root = new TreeNode(slow.next.val);
            root.right = sortedListToBST(slow.next.next);
            slow.next = null;
            root.left = sortedListToBST(head);
            return root;
        }
    }
}
