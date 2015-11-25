package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 11/24/15.
 */
public class NimGame {
    public static class Solution {
        public boolean canWinNim(int n) {
            if (n <= 3) return true;
            if (n == 4) return false;

            boolean[] res = new boolean[3];
            res[0] = true;
            res[1] = true;
            res[2] = false;
            // res[3] = false;

            for (int i = 4; i < n; i++) {
                boolean tmp = !res[2] || !res[1] || !res[0];
                res[0] = res[1];
                res[1] = res[2];
                res[2] = tmp;
            }
            return res[2];
        }

        //O(1)
        public boolean canWinNim2(int n) {
            // say player A and B
            // if n = 4k, then whatever A removes, B can make A + B = 4.
            // And finally there are 4 stones left for A to remove, then A loses.
            // if n = 4k + i(i <= 3), then A can remove i stones first,
            // and then B would face the above scenario and lose.
            return n % 4 != 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canWinNim2(1348820612));
    }
}
