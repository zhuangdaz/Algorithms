package com.betterman.algorithms.leetcode.medium;

import java.util.Stack;

/**
 * Created by zhuangda on 3/3/16.
 */
public class VerifyPreorderSequenceInBST {
    public class Solution {
        public boolean verifyPreorder(int[] preorder) {
            Stack<Integer> path = new Stack();
            int low = Integer.MIN_VALUE;

            for (int num : preorder) {
                if (num < low) return false;

                while (!path.empty() && path.peek() < num) {
                    low = path.pop();
                }

                path.push(num);
            }
            return true;
        }

        public boolean verifyPreorderConstantSpace(int[] preorder) {
            int low = Integer.MIN_VALUE;
            int i = -1;

            for (int num : preorder) {
                if (num < low) return false;

                while(i >= 0 && preorder[i] < num) {
                    low = preorder[i--];
                }

                preorder[++i] = num;
            }
            return true;
        }
    }
}
