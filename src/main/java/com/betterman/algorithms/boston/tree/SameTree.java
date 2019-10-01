package com.betterman.algorithms.boston.tree;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return true;
    }

    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        if (!check(p, q)) return false;

        Queue<TreeNode> pQ = new LinkedList<>();
        Queue<TreeNode> qQ = new LinkedList<>();

        if (p != null) {
            pQ.offer(p);
            qQ.offer(q);
        }

        while (!pQ.isEmpty()) {
            TreeNode pN = pQ.poll();
            TreeNode qN = qQ.poll();

            if (!check(pN.left, qN.left)) {
                return false;
            }

            if (pN.left != null) {
                pQ.offer(pN.left);
                qQ.offer(qN.left);
            }

            if (!check(pN.right, qN.right)) {
                return false;
            }

            if (pN.right != null) {
                pQ.offer(pN.right);
                qQ.offer(qN.right);
            }
        }

        return true;
    }
}
