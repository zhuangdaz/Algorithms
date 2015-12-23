package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/23/15.
 */


/**
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p>
 * Note: m and n will be at most 100.
 */
public class UniquePathII {
    public class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int rows = obstacleGrid.length;
            int cols = obstacleGrid[0].length;
            int[] row = new int[cols + 1];
            row[cols - 1] = 1;
            for (int i = rows - 1; i > -1; i--) {
                for (int j = cols - 1; j > -1; j--) {
                    if (obstacleGrid[i][j] == 1) {
                        row[j] = 0;
                    } else {
                        row[j] += row[j + 1];
                    }
                }
            }

            return row[0];
        }
    }
}
