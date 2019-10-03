package com.betterman.algorithms.boston.tree;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.Stack;

public class KthSmallestElementBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (--k == 0) {
                return root.val;
            }

            root = root.right;
        }
        return 0;
    }
}
