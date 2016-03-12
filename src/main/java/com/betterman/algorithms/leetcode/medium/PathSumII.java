package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 3/11/16.
 */
public class PathSumII {
    public class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> ans = new ArrayList();
            if (root != null) {
                dfs(new ArrayList(), root, sum, ans);
            }
            return ans;
        }

        private void dfs(List<Integer> path, TreeNode node, int sum, List<List<Integer>> ans) {
            path.add(node.val);
            if (node.left == null && node.right == null) {
                if (node.val == sum) {
                    List<Integer> res = new ArrayList();
                    res.addAll(path);
                    ans.add(res);
                }
            }

            if (node.left != null) {
                dfs(path, node.left, sum - node.val, ans);
            }

            if (node.right != null) {
                dfs(path, node.right, sum - node.val, ans);
            }

            path.remove(path.size() - 1);
        }
    }
}
