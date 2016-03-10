package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhuangda on 3/9/16.
 */

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from
 * left to right, level by level from leaf to root).
 */
public class BinaryTreeLevelOrderTraversalII {
    public class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans = new LinkedList();
            dfs(ans, 1, root);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, int level, TreeNode root) {
            if (root == null) return;

            if (ans.size() < level) {
                List<Integer> row = new LinkedList();
                row.add(root.val);
                ans.add(0, row);
            } else {
                ans.get(ans.size() - level).add(root.val);
            }
            dfs(ans, level + 1, root.left);
            dfs(ans, level + 1, root.right);
        }
    }
}
