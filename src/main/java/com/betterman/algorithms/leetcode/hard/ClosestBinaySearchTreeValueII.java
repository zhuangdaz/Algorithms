package com.betterman.algorithms.leetcode.hard;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhuangda on 3/5/16.
 */

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are
 * closest to the target.
 *
 * Note: Given target value is a floating point. You may assume k is always valid, that is: k ≤
 * total nodes. You are guaranteed to have only one unique set of k values in the BST that are
 * closest to the target. Follow up: Assume that the BST is balanced, could you solve it in less
 * than O(n) runtime (where n = total nodes)?
 */
public class ClosestBinaySearchTreeValueII {
    public class Solution {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            Stack<Integer> predecessor = new Stack();
            Stack<Integer> successor = new Stack();

            inorder(root, target, predecessor, false);
            inorder(root, target, successor, true);

            List<Integer> ans = new ArrayList();
            while (k-- > 0) {
                if (predecessor.empty()) {
                    ans.add(successor.pop());
                } else if (successor.empty()) {
                    ans.add(predecessor.pop());
                } else if (Double.compare(target - predecessor.peek(), successor.peek() - target) <= 0) {
                    ans.add(predecessor.pop());
                } else {
                    ans.add(successor.pop());
                }
            }

            return ans;
        }

        private void inorder(TreeNode root, double target, Stack<Integer> stack, boolean reversed) {
            if (root == null) return;

            inorder(!reversed ? root.left : root.right, target, stack, reversed);

            if ((!reversed && root.val > target) || (reversed && root.val <= target)) return;

            stack.push(root.val);

            inorder(!reversed ? root.right : root.left, target, stack, reversed);
        }
    }
}
