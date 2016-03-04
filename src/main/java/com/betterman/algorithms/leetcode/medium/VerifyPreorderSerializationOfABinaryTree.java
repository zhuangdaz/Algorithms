package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 3/4/16.
 */
public class VerifyPreorderSerializationOfABinaryTree {
    public class Solution {
        public boolean isValidSerialization(String preorder) {
            String[] parts = preorder.split(",");
            int stack = 1;

            for (int i = 0; i < parts.length; i++) {
                if (!"#".equals(parts[i])) {
                    stack++;
                } else {
                    stack--;
                    if (stack == 0 && i < parts.length - 1) return false;
                }
            }
            return stack == 0;
        }
    }
}
