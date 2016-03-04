package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhuangda on 3/4/16.
 */

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * For example: Given binary tree {1,#,2,3}, return [1,2,3].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
    public class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            Stack<TreeNode> s = new Stack();
            List<Integer> ans = new ArrayList();
            TreeNode n = root;

            while (n != null || !s.empty()) {
                if (n != null) {
                    ans.add(n.val);
                    s.push(n.right);
                    n = n.left;
                } else {
                    n = s.pop();
                }
            }
            return ans;
        }
    }
}
