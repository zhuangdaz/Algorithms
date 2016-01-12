package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhuangda on 1/11/16.
 */

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * <p>
 * If two nodes are in the same row and column, the order should be from left to right.
 * <p>
 * Examples:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its vertical order traversal as:
 * [
 * [9],
 * [3,15],
 * [20],
 * [7]
 * ]
 * Given binary tree [3,9,20,4,5,2,7],
 * _3_
 * /   \
 * 9    20
 * / \   / \
 * 4   5 2   7
 * return its vertical order traversal as:
 * [
 * [4],
 * [9],
 * [3,5,2],
 * [20],
 * [7]
 * ]
 */
public class BinaryTreeVerticalOrderTraversal {
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

        // [1,2,3,null,4]
        // from top to bottom
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList();
            if (root == null) return res;

            int[] minMax = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
            computeRange(minMax, root, 0);
            for (int i = minMax[0]; i <= minMax[1]; i++) {
                res.add(new ArrayList());
            }

            Queue<TreeNode> qn = new LinkedList();
            Queue<Integer> qc = new LinkedList();

            qn.add(root);
            qc.add(-minMax[0]);

            while (!qn.isEmpty()) {
                TreeNode n = qn.poll();
                Integer col = qc.poll();
                res.get(col).add(n.val);
                if (n.left != null) {
                    qn.add(n.left);
                    qc.add(col - 1);
                }

                if (n.right != null) {
                    qn.add(n.right);
                    qc.add(col + 1);
                }
            }
            return res;
        }


        private void computeRange(int[] minMax, TreeNode n, int col) {
            if (n == null) return;

            if (minMax[0] > col) minMax[0] = col;
            if (minMax[1] < col) minMax[1] = col;
            computeRange(minMax, n.left, col - 1);
            computeRange(minMax, n.right, col + 1);
        }
    }
}
