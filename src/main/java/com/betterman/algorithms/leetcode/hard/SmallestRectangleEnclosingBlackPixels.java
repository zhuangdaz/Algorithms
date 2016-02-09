package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 2/8/16.
 */
public class SmallestRectangleEnclosingBlackPixels {
    public class Solution {
        public int minArea(char[][] image, int x, int y) {
            int m = image.length, n = image[0].length;
            int left = search(image, 0, y, 0, m, true, false);
            int right = search(image, y + 1, n, 0, m, false, false);
            int top = search(image, 0, x, 0, n, true, true);
            int bottom = search(image, x + 1, m, 0, n, false, true);
            return (right - left) * (bottom - top);
        }

        private int search(char[][] image, int i, int j, int lo, int hi, boolean opt, boolean isRow) {
            while (i < j) {
                int mid = (i + j) / 2;
                int k = lo;
                while (k < hi && isWhite(image, mid, k, isRow)) k++;
                //if opt is true, binary search direction is from low to high
                if (k < hi == opt) {
                    j = mid;
                } else {
                    i = mid + 1;
                }
            }
            return i;
        }

        private boolean isWhite(char[][] image, int mid, int k, boolean isRow) {
            return (isRow ? image[mid][k] : image[k][mid]) == '0';
        }
    }
}
