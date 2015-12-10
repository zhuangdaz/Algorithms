package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 12/9/15.
 */
public class EditDistance {
    public static class Solution {
        //O(nm)
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[][] cost = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                cost[i][0] = i;
            }

            for (int j = 0; j <= n; j++) {
                cost[0][j] = j;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (word1.charAt(i) == word2.charAt(j))
                        cost[i + 1][j + 1] = cost[i][j];

                    else {
                        cost[i + 1][j + 1] =
                            Math.min(
                                Math.min(
                                    cost[i + 1][j],
                                    cost[i][j + 1]
                                ),
                                cost[i][j]
                            ) + 1;
                    }
                }
            }
            return cost[m][n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String word1 = "a";
        String word2 = "ab";
        System.out.println(solution.minDistance(word1, word2));
    }
}
