package com.betterman.algorithms.leetcode2.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

/**
 * Created by zhuangda on 3/14/16.
 */
public class BinaryTreeUpsideDown {
    public class Solution {
        public TreeNode upsideDownBinaryTree(TreeNode root) {
            if (root == null) return null;
            if (root.left == null) return root;

            TreeNode newRoot = upsideDownBinaryTree(root.left);

            TreeNode parent = root.left;
            parent.left = root.right;
            parent.right = root;

            root.left = null;
            root.right = null;
            return newRoot;
        }
    }
}
