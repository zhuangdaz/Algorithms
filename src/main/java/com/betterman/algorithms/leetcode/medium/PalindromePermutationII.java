package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 2/28/16.
 */
public class PalindromePermutationII {
    public class Solution {
        public List<String> generatePalindromes(String s) {
            int[] map = new int[256];
            int odds = 0;

            char[] chs = s.toCharArray();
            for (char c : chs) {
                map[c]++;
                if (map[c] % 2 != 0) {
                    odds++;
                } else {
                    odds--;
                }
            }

            List<String> ans = new ArrayList();
            if (odds > 1) return ans;
            String mid = "";

            for (int i = 0; i < map.length; i++) {
                if (map[i] % 2 != 0) mid += (char) i;
                map[i] /= 2;
            }

            helper(map, new StringBuffer(), s.length() / 2, mid, ans);
            return ans;
        }

        private void helper(int[] map, StringBuffer path, int len, String mid, List<String> ans) {
            if (path.length() == len) {
                StringBuilder reverse = new StringBuilder(path).reverse();
                ans.add(path + mid + reverse);
                return;
            }

            for (int i = 0; i < map.length; i++) {
                if (map[i] > 0) {
                    map[i]--;
                    path.append((char) i);
                    helper(map, path, len, mid, ans);
                    path.deleteCharAt(path.length() - 1);
                    map[i]++;
                }
            }
        }
    }
}
