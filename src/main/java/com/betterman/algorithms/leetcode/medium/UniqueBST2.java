package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 2/15/16.
 */
public class UniqueBST2 {
    public class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new ArrayList();
            return gen(1, n);
        }

        private List<TreeNode> gen(int start, int end) {
            List<TreeNode> ans = new ArrayList();

            if (start > end) {
                ans.add(null);
                return ans;
            }

            List<TreeNode> left, right;
            for (int i = start; i <= end; i++) {
                left = gen(start, i - 1);
                right = gen(i + 1, end);

                for (TreeNode ln : left) {
                    for (TreeNode rn : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = ln;
                        root.right = rn;
                        ans.add(root);
                    }
                }
            }
            return ans;
        }
    }
}
