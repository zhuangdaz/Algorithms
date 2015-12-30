package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuangda on 12/29/15.
 */
public class ConstructBinaryTreeInorderPostorder {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer, Integer> map = new HashMap();
            for (int i= 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
        }

        private TreeNode helper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> map) {
            if (is > ie) return null;

            TreeNode root = new TreeNode(postorder[pe]);
            int rootIdx = map.get(postorder[pe]);
            TreeNode left = helper(inorder, is, rootIdx - 1, postorder, ps, ps + rootIdx - 1 - is, map);
            TreeNode right = helper(inorder, rootIdx + 1, ie, postorder, ps + rootIdx - is, pe - 1, map);
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
