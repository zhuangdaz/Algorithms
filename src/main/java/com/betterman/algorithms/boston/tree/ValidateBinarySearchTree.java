package com.betterman.algorithms.boston.tree;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.Stack;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        if (lower != null && node.val <= lower
                ||
                upper != null && node.val >= upper) {
            return false;
        }

        return helper(node.left, lower, node.val) &&
                helper(node.right, node.val, upper);
    }

    public boolean isValidBSTWithInorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        Integer lower = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (lower != null && root.val <= lower) {
                return false;
            }

            lower = root.val;
            root = root.right;
        }
        return true;
    }
}
