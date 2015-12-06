package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 12/5/15.
 */
public class StrStr {
    public static class Solution {
        //O(mn)
        public int strStr(String haystack, String needle) {
            if (needle.isEmpty()) return 0;
            for (int i = 0; i <= haystack.length() - needle.length(); ) {
                int next = i + 1;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) == needle.charAt(0)) {
                        next = i + j;
                    }

                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }

                    if (j == needle.length() - 1) return i;
                }
                i = next;
            }
            return -1;
        }

        //O(m+n)
        public int strStrKMP(String haystack, String needle) {
            if (needle.isEmpty()) return 0;
            int[] P = kmp(needle);
            int j = -1;
            // j is up-until-now matched index in needle string
            // i is up-until-now going to matched index in the haystack string
            for (int i = 0; i < haystack.length(); i++) {
                while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                    j = P[j] - 1;
                }

                if (haystack.charAt(i) == needle.charAt(j + 1)) {
                    j++;
                    if (j == needle.length() - 1) {
                        return i - needle.length() + 1;
                    }
                }


            }
            return -1;
        }

        // O(m)
        private int[] kmp(String str) {
            int[] ret = new int[str.length()];

            for (int i = 1; i < ret.length; i++) {
                int j = ret[i - 1] - 1;
                while (j >= 0 && str.charAt(i) != str.charAt(j + 1)) {
                    j = ret[j] - 1;
                }

                if (str.charAt(i) == str.charAt(j + 1)) {
                    ret[i] = j + 2;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.strStrKMP("aaba",
            "aba"));

//        System.out.println(
//            Arrays.toString(solution.kmp("aba"))
//        );
    }
}
