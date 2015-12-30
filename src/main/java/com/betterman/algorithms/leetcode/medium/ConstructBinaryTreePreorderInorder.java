package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuangda on 12/30/15.
 */
public class ConstructBinaryTreePreorderInorder {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        }


        private TreeNode helper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> map) {
            if (ps > pe) return null;

            TreeNode root = new TreeNode(preorder[ps]);
            int rootIdx = map.get(preorder[ps]);
            TreeNode left = helper(preorder, ps + 1, ps + rootIdx - is, inorder, is, rootIdx - 1, map);
            TreeNode right = helper(preorder, ps + rootIdx - is + 1, pe, inorder, rootIdx + 1, ie, map);

            root.left = left;
            root.right = right;
            return root;
        }
    }
}
