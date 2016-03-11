package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhuangda on 3/11/16.
 */
public class MinimumDepthOfBinaryTree {
    public class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            int depth = 1;
            Queue<TreeNode> q = new LinkedList();
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    TreeNode n = q.poll();
                    if (n.left == null && n.right == null) return depth;
                    if (n.left != null) q.offer(n.left);
                    if (n.right != null) q.offer(n.right);
                }
                depth++;
            }
            return depth;
        }
    }
}
