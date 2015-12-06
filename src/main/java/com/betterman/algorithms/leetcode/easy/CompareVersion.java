package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 12/3/15.
 */
public class CompareVersion {
    //note:
    //1. for special characters like ".", "*", should have double backslash
    //2. special case: 1.0, 1; 01, 1

    public static class Solution {
        public int compareVersion(String version1, String version2) {
            String[] revisions1 = version1.split("\\.");
            String[] revisions2 = version2.split("\\.");

            int i = 0;
            while(i < Math.max(revisions1.length, revisions2.length)) {
                Integer rev1 = i < revisions1.length ? new Integer(revisions1[i]) : 0;
                Integer rev2 = i < revisions2.length ? new Integer(revisions2[i]) : 0;
                if (rev1.equals(rev2)) {
                    i++;
                } else if (rev1 > rev2) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compareVersion("01", "1"));
    }
}
