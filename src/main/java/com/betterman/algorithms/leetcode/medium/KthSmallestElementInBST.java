package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * Created by zhuangda on 2/5/16.
 */
public class KthSmallestElementInBST {
    public class Solution {
        public int kthSmallest(TreeNode root, int k) {
            int left = count(root.left);
            if (left >= k) return kthSmallest(root.left, k);
            else if (left == k - 1) return root.val;
            else return kthSmallest(root.right, k - left - 1);
        }

        private int count(TreeNode node) {
            if (node == null) return 0;

            return count(node.left) + 1 + count(node.right);
        }

        public int kthSmallestStack(TreeNode root, int k) {
            Stack<TreeNode> s = new Stack();
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            while (!s.isEmpty()) {
                root = s.pop();
                k--;
                if (k == 0) return root.val;

                root = root.right;
                while (root != null) {
                    s.push(root);
                    root = root.left;
                }
            }
            return 0;
        }
    }
}
