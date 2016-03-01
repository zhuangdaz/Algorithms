package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhuangda on 2/29/16.
 */
public class PalindromePartitioning {
    public class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList();
            dfs(s.toCharArray(), 0, new ArrayList(), ans);
            return ans;
        }

        private void dfs(char[] chs, int start, List<String> path, List<List<String>> ans) {
            if (start == chs.length) {
                ans.add(new ArrayList(path));
                return;
            }

            for (int i = start; i < chs.length; i++) {
                if (isPalindrome(chs, start, i)) {
                    path.add(new String(Arrays.copyOfRange(chs, start, i + 1)));
                    dfs(chs, i + 1, path, ans);
                    path.remove(path.size() - 1);
                }
            }
        }

        private boolean isPalindrome(char[] chs, int i, int j) {
            while (i < j) {
                if (chs[i++] != chs[j--]) return false;
            }
            return true;
        }
    }
}
