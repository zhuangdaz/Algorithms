package com.zhuangda.leetcode.medium;

import java.util.HashMap;

/**
 * Created by zhuangda on 11/10/15.
 */
public class FractionToRecurringDecimal {
    public static class Solution {
        // key: how to know it is repeating.
        // when calculating the fraction part, if we encounter a already processed numerator, then we know it starts to repeat
        // corner case,
        // 1. denominator should not be 0
        // 2. negative sign
        // 3. if the result is endless non-recurring, what should we return?
        // 4. overflow:-2147483648 / -1
        public String fractionToDecimal(int numerator, int denominator) {
            if (denominator == 0) {
                return null;
            }

            long n = (long) numerator;
            long d = (long) denominator;

            StringBuffer ret = new StringBuffer();
            if (n * d < 0) {
                ret.append("-");
            }

            n = Math.abs(n);
            d = Math.abs(d);

            ret.append(n / d);

            HashMap<Long, Integer> processed = new HashMap();

            long r = n % d;

            if (r == 0) {
                return ret.toString();
            }

            ret.append(".");

            while (r != 0) {
                if (processed.containsKey(r)) {
                    ret.insert(processed.get(r), "(");
                    ret.append(")");
                    return ret.toString();
                }

                processed.put(r, ret.length());
                r *= 10;
                ret.append(r / d);
                r %= d;
            }
            return ret.toString();
        }
    }

    public static void main(String[] args) {
        int numerator = -1;
        int denumerator = Integer.MIN_VALUE;
        Solution solution = new Solution();
        System.out.println(solution.fractionToDecimal(numerator, denumerator));
    }
}
