package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 1/4/16.
 */
public class MaximalRectangle {
    public class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return 0;
            int m = matrix.length, n = matrix[0].length;
            int[] h = new int[n + 1];  //genius idea
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') h[j]++;
                    else h[j] = 0;
                }

                int area = helper(h);
                if (area > max) max = area;
            }
            return max;
        }

        private int helper(int[] height) {
            int[] s = new int[height.length];
            int max = 0, top = -1;

            for (int i = 0; i < height.length; i++) {
                int h = height[i];

                while (top > -1 && height[s[top]] >= h) {
                    int index = s[top--];
                    int leftIndex = top == -1 ? 0 : s[top] + 1;
                    int area = height[index] * (i - leftIndex);
                    if (area > max) max = area;
                }
                s[++top] = i;
            }
            return max;
        }
    }
}
