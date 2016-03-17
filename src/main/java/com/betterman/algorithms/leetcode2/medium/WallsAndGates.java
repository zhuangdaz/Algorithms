package com.betterman.algorithms.leetcode2.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhuangda on 3/14/16.
 */
public class WallsAndGates {
    public class Solution {
        public void wallsAndGates(int[][] rooms) {
            if (rooms.length == 0 || rooms[0].length == 0) return;
            Queue<int[]> q = new LinkedList();

            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms[0].length; j++) {
                    if (rooms[i][j] == 0) q.offer(new int[]{i, j});
                }
            }

            while (!q.isEmpty()) {
                int[] next = q.poll();
                int row = next[0];
                int col = next[1];

                if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                    rooms[row - 1][col] = rooms[row][col] + 1;
                    q.offer(new int[]{row - 1, col});
                }

                if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                    rooms[row + 1][col] = rooms[row][col] + 1;
                    q.offer(new int[]{row + 1, col});
                }

                if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                    rooms[row][col - 1] = rooms[row][col] + 1;
                    q.offer(new int[]{row, col - 1});
                }

                if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                    rooms[row][col + 1] = rooms[row][col] + 1;
                    q.offer(new int[]{row, col + 1});
                }

            }
        }
    }
}
