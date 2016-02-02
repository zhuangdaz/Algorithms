package com.betterman.algorithms.leetcode.hard;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhuangda on 2/1/16.
 */
public class CountOfSmallerNumbersAfterSelf {
    public class Solution {
        private class Node {
            public int val, sum, dup = 1;
            public Node left, right;

            public Node(int s, int v) {
                sum = s;
                val = v;
            }
        }

        public List<Integer> countSmaller(int[] nums) {
            Integer[] ans = new Integer[nums.length];
            Node root = null;
            for (int i = nums.length - 1; i >= 0; i--) {
                root = insert(root, nums[i], i, ans, 0);
            }
            return Arrays.asList(ans);
        }

        private Node insert(Node node, int num, int i, Integer[] ans, int preSum) {
            if (node == null) {
                node = new Node(0, num);
                ans[i] = preSum;
            } else if (node.val < num) {
                node.right = insert(node.right, num, i, ans, preSum + node.sum + node.dup);
            } else if (node.val > num) {
                node.left = insert(node.left, num, i, ans, preSum);
                node.sum++;
            } else {
                node.dup++;
                ans[i] = preSum + node.sum;
            }
            return node;
        }
    }
}
