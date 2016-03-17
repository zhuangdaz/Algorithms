package com.betterman.algorithms.leetcode2.medium;

/**
 * Created by zhuangda on 3/12/16.
 */
public class NumberOfConnectedComponentsInUndirectedGraph {
    public class Solution {
        public int countComponents(int n, int[][] edges) {
            int[] roots = new int[n];

            for (int i = 0; i < n; i++) {
                roots[i] = i;
            }

            for (int[] e : edges) {
                int r1 = root(roots, e[0]);
                int r2 = root(roots, e[1]);
                if (r1 != r2) {
                    roots[r1] = r2; //union
                    n--;
                }
            }

            return n;
        }

        private int root(int[] roots, int i) {
            while (i != roots[i]) {
                roots[i] = roots[roots[i]];  //path compression
                i = roots[i];
            }
            return i;
        }
    }
}
