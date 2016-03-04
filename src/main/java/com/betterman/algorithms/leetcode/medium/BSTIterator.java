package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 3/4/16.
 */

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the
 * root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the
 * height of the tree.
 */
public class BSTIterator {
    Stack<TreeNode> s = new Stack();

    public BSTIterator(TreeNode root) {
        TreeNode n = root;
        while (n != null) {
            s.push(n);
            n = n.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !s.empty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode n = s.pop();
        int val = n.val;

        n = n.right;
        while (n != null) {
            s.push(n);
            n = n.left;
        }

        return val;
    }
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new BSTIterator(root); while
 * (i.hasNext()) v[f()] = i.next();
 */
