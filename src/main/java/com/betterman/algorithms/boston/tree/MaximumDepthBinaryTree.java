package com.betterman.algorithms.boston.tree;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthBinaryTree {
    public int maxDepthIterative(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            Queue<TreeNode> tmp = new LinkedList<>();
            depth++;
            while (!q.isEmpty()) {
                TreeNode n = q.poll();
                if (n.left != null) {
                    tmp.offer(n.left);
                }
                if (n.right != null) {
                    tmp.offer(n.right);
                }
            }
            q = tmp;
        }
        return depth;
    }

    public int maxDepthRecursive(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right)) + 1;
    }

    public static void main(String[] args) {
        if (null == null) {
            System.out.println("null is equal!");
        }
    }
}
