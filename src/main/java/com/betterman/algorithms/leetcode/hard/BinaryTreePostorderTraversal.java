package com.betterman.algorithms.leetcode.hard;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhuangda on 3/5/16.
 */
public class BinaryTreePostorderTraversal {
    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
     * right; TreeNode(int x) { val = x; } }
     */
    public class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new LinkedList();

            Stack<TreeNode> s = new Stack();
            if (root != null)
                s.push(root);

            while (!s.empty()) {
                TreeNode n = s.pop();
                ans.add(0, n.val);

                if (n.left != null) s.push(n.left);
                if (n.right != null) s.push(n.right);
            }

            return ans;

        }

        //Universal iterative solution for all tree traversals
        //https://leetcode.com/discuss/9736/accepted-code-with-explaination-does-anyone-have-better-idea#a21531

        /**
         * There is an universal idea for preorder traversal inorder traversal and postorder
         * traversal. For each node N, we process it as follows:------- push N in stack -> push left
         * tree of N in stack -> pop left tree of N -> push right tree of N in stack -> pop right
         * tree of N -> pop N---------
         * For preorder traversal, we visit a node when pushing it in stack.
         *
         * For inorder traversal, we visit a node when pushing its right child in stack.
         *
         * For postorder traversal, we visit a node when popping it.
         *
         * lastpop represents the node which is popped the last time.
         * For the top node in stack, it has three choices, pushing its
         * left child in stack, or pushing its right child in stack, or being popped. If lastpop !=
         * top->left, meaning that its left tree has not been pushed in stack, then we push its left
         * child. If last_pop == top->left, we push its right child. Otherwise, we pop the top
         * node.
         */
        public List<Integer> postorderTraversalUniversal(TreeNode root) {
            List<Integer> ans = new LinkedList();

            Stack<TreeNode> s = new Stack();
            if (root != null)
                s.push(root);
            TreeNode lastPop = root;
            while (!s.empty()) {
                TreeNode n = s.peek();

                if (n.left != null && n.left != lastPop && n.right != lastPop) {
                    s.push(n.left);
                } else if (n.right != null && n.right != lastPop && (n.left == null || n.left == lastPop)) {
                    s.push(n.right);
                } else {
                    s.pop();
                    ans.add(n.val);
                    lastPop = n;
                }
            }
            return ans;
        }
    }
}
