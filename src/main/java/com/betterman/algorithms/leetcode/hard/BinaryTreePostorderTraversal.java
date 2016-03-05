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
        //https://leetcode.com/discuss/9736/accepted-code-with-explaination-does-anyone-have-better-idea
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
