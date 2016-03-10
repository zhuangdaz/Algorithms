package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhuangda on 3/10/16.
 */
public class BinaryTreeLevelOrderTraversal {
    public class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new LinkedList();
            dfs(ans, 0, root);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, int level, TreeNode root) {
            if (root == null) return;

            if (ans.size() <= level) {
                List<Integer> row = new LinkedList();
                row.add(root.val);
                ans.add(row);
            } else {
                ans.get(level).add(root.val);
            }
            dfs(ans, level + 1, root.left);
            dfs(ans, level + 1, root.right);
        }
    }
}
