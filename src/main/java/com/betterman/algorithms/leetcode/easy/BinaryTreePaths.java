package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 3/11/16.
 */
public class BinaryTreePaths {
    public class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList();
            if (root != null) dfs("", root, ans);
            return ans;
        }

        private void dfs(String path, TreeNode node, List<String> ans) {
            path += node.val;
            if (node.left == null && node.right == null) {
                ans.add(path);
                return;
            }

            if (node.left != null) dfs(path + "->", node.left, ans);
            if (node.right != null) dfs(path + "->", node.right, ans);
        }
    }
}
