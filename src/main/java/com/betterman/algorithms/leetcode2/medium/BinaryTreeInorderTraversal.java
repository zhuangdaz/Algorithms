package com.betterman.algorithms.leetcode2.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhuangda on 3/14/16.
 */

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [1,3,2].
 *
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
    /**
     * There is an universal idea for preorder traversal inorder traversal and postorder traversal.
     * For each node N, we process it as follows:------- push N in stack -> push left tree of N in
     * stack -> pop left tree of N -> push right tree of N in stack -> pop right tree of N -> pop
     * N--------- For preorder traversal, we visit a node when pushing it in stack.
     *
     * For inorder traversal, we visit a node when pushing its right child in stack.
     *
     * For postorder traversal, we visit a node when popping it.
     *
     * lastpop represents the node which is popped the last time. For the top node in stack, it has
     * three choices, pushing its left child in stack, or pushing its right child in stack, or being
     * popped. If lastpop != top->left, meaning that its left tree has not been pushed in stack,
     * then we push its left child. If last_pop == top->left, we push its right child. Otherwise, we
     * pop the top node.
     */
    public class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList();
            if (root == null) return ans;
            Stack<TreeNode> s = new Stack();
            s.push(root);
            TreeNode lastPop = root;

            while (!s.isEmpty()) {
                TreeNode n = s.peek();

                if (n.left != null && lastPop != n.left && lastPop != n.right) {
                    s.push(n.left);
                } else if (n.right != null && lastPop != n.right) {
                    ans.add(n.val);
                    s.push(n.right);
                } else {
                    s.pop();
                    lastPop = n;
                    if (n.right == null) {
                        ans.add(n.val);
                    }
                }
            }
            return ans;
        }
    }

}
