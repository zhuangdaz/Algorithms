package com.betterman.algorithms.leetcode.easy;

import java.util.BitSet;

/**
 * Created by zhuangda on 1/10/16.
 */
public class CountPrime {
    public class Solution {
        public int countPrimes(int n) {
            if (n <= 2) return 0;
            BitSet notPrime = new BitSet(n);
            notPrime.set(1);
            for (int i = 2; i * i < n; i++) {
                if (!notPrime.get(i)) {
                    for (int j = i * i; j < n; j += i) {
                        notPrime.set(j);
                    }
                }
            }
            return n - 1 - notPrime.cardinality();
        }
    }
}
