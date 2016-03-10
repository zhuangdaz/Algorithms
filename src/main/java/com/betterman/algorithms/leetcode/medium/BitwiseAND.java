package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 3/8/16.
 */
public class BitwiseAND {
    public class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int step = 1;
            while(m != n) {
                m >>= 1;
                n >>= 1;
                step <<= 1;
            }

            return m * step;
        }
    }
}
