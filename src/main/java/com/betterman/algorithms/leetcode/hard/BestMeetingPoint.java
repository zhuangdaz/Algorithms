package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 1/28/16.
 */
public class BestMeetingPoint {
    public class Solution {
        //Runtime: O(mn)
        //Space: O(m+n)
        public int minTotalDistance(int[][] grid) {
            int[] I = new int[grid.length];
            int[] J = new int[grid[0].length];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        I[i]++;
                        J[j]++;
                    }
                }
            }

            int total = 0;
            for (int[] K : new int[][]{I, J}) {
                int i = 0, j = K.length - 1;
                while (i < j) {
                    int cnt = Math.min(K[i], K[j]);
                    total += cnt * (j - i);
                    if ((K[i] -= cnt) == 0) i++;
                    if ((K[j] -= cnt) == 0) j--;
                }
            }
            return total;
        }
    }
}
