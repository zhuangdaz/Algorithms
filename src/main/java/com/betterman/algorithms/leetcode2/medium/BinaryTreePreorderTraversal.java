package com.betterman.algorithms.leetcode2.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhuangda on 3/13/16.
 */

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
    public class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList();

            if (root == null) return ans;
            Stack<TreeNode> s = new Stack();
            s.push(root);

            while (!s.empty()) {
                TreeNode node = s.pop();
                ans.add(node.val);
                if (node.right != null) s.push(node.right);
                if (node.left != null) s.push(node.left);
            }
            return ans;
        }
    }
}
