package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 12/7/15.
 */
public class RestorIPAddress {
    public static class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList();
            helper(res, s, "", 3);
            return res;
        }


        private void helper(List<String> res, String left, String sofar, int level) {
            if (level == -1 && left.isEmpty()) {
                res.add(sofar);
                return;
            }

            // don't check for impossible string
            if (left.length() < level + 1 || left.length() > 3 * (level + 1))
                return;

            for (int i = 0; i < 3 && i < left.length(); i++) {
                String numStr = left.substring(0, i + 1);
                int num = new Integer(numStr);
                if (num <= 255) {
                    String str = sofar.isEmpty() ? numStr : sofar + "." + numStr;
                    helper(res, left.substring(i + 1), str, level - 1);
                }

                if (num == 0) break; //not accept 0X, 0XX
            }
            return;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "0000";
        System.out.println(solution.restoreIpAddresses(input));
    }
}
