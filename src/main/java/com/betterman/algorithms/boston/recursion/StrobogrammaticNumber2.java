package com.betterman.algorithms.boston.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 247. Strobogrammatic Number II
 * <p>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * <p>
 * Find all strobogrammatic numbers that are of length = n.
 * <p>
 * For example,
 * Given n = 2, return ["11","69","88","96"].
 * <p>
 * Companies: Google
 * Related Topics: Math, Recursion
 * Similar Questions: (E) Strobogrammatic Number, (H) Strobogrammatic Number III
 */

public class StrobogrammaticNumber2 {
    char[][] digitPair = new char[][]{{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};

    /**
     * Recursive solution
     * n = 0, returns [""]
     * n = 1, returns ["0", "1", "8"]
     * n > 1,
     * 1) get the inner lists of n - 2
     * 2) add digitPair to left and right sides of the substring.
     * 3) notes: 0 can't be added to left most position so needs an extra flag to indicate if the current position is the leftmost.
     */
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private List<String> helper(int m, int n) {
        if (m == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }

        if (m == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }

        List<String> subList = helper(m - 2, n);
        List<String> res = new ArrayList<>();
        for (String subString : subList) {
            for (int i = 0; i < digitPair.length; i++) {
                if (i == 0 && m == n) {
                    continue;
                }
                res.add(digitPair[i][0] + subString + digitPair[i][1]);
            }
        }
        return res;
    }

    /**
     * Iterative Solution
     */
    public List<String> findStrobogrammaticIterative(int n) {
        int len = 0;
        List<String> res = new ArrayList<>(Arrays.asList(""));
        if (n % 2 != 0) {
            len = 1;
            res = new ArrayList<>(Arrays.asList("0", "1", "8"));
        }

        for (len = len + 2; len <= n; len = len + 2) {
            List<String> newRes = new ArrayList<>();
            for (String subString : res) {
                for (int j = 0; j < digitPair.length; j++) {
                    if (j == 0 && len == n) {
                        continue;
                    }
                    newRes.add(digitPair[j][0] + subString + digitPair[j][1]);
                }
            }
            res = newRes;
        }
        return res;
    }

    public static void main(String[] args) {
        StrobogrammaticNumber2 sol = new StrobogrammaticNumber2();
//        System.out.println(sol.findStrobogrammatic(0));
//        System.out.println(sol.findStrobogrammatic(1));
//        System.out.println(sol.findStrobogrammatic(2));
//        System.out.println(sol.findStrobogrammatic(3));
//        System.out.println(sol.findStrobogrammatic(4));
        System.out.println(sol.findStrobogrammaticIterative(0));
        System.out.println(sol.findStrobogrammaticIterative(1));
        System.out.println(sol.findStrobogrammaticIterative(2));
        System.out.println(sol.findStrobogrammaticIterative(3));
        System.out.println(sol.findStrobogrammaticIterative(4));
    }
}
