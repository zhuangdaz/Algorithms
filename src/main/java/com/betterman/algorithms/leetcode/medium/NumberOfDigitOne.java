package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 1/23/16.
 */
public class NumberOfDigitOne {
    public static class Solution {
        //O(logn) log10
        public int countDigitOne(int n) {
            int cnt = 0;

            //use long to avoid overflow
            for (long m = 1; m <= n; m *= 10) {
                long a = n / m;
                long b = n % m;
                cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
//        System.out.println(1000000000 * 10);  // ==1410065408 !?
        System.out.println(solution.countDigitOne(1410065408));
    }
}
