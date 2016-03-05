package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhuangda on 3/5/16.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList();
            Stack<TreeNode> s = new Stack();
            if (root != null)
                s.push(root);
            boolean left = true;
            while (!s.empty()) {
                List<Integer> row = new ArrayList();
                Stack<TreeNode> tmp = new Stack();
                while (!s.empty()) {
                    TreeNode n = s.pop();
                    row.add(n.val);
                    if (left) {
                        if (n.left != null) tmp.push(n.left);
                        if (n.right != null) tmp.push(n.right);
                    } else {
                        if (n.right != null) tmp.push(n.right);
                        if (n.left != null) tmp.push(n.left);
                    }
                }
                s = tmp;
                ans.add(row);
                left ^= true;
            }
            return ans;
        }


        public List<List<Integer>> zigzagLevelOrderRec(TreeNode root) {
            List<List<Integer>> ans = new ArrayList();
            dfs(root, ans, 1);
            return ans;
        }

        private void dfs(TreeNode curr, List<List<Integer>> ans, int level) {
            if (curr == null) return;

            if (ans.size() < level) {
                ans.add(new LinkedList());
            }

            List<Integer> row = ans.get(level - 1);

            if (level % 2 != 0) { //left to right
                row.add(curr.val);
            } else { //right to left
                row.add(0, curr.val);
            }

            dfs(curr.left, ans, level + 1);
            dfs(curr.right, ans, level + 1);
        }
    }
}
