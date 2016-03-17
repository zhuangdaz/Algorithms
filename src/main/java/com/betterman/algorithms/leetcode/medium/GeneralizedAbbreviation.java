package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 2/28/16.
 */
public class GeneralizedAbbreviation {
    public class Solution {
        public List<String> generateAbbreviations(String word) {
            List<String> ans = new ArrayList();
            helper(word, 0, 0, new StringBuilder(), ans);
            return ans;
        }

        private void helper(String word, int index, int count, StringBuilder path, List<String> ans) {
            int len = path.length();
            if (index >= word.length()) {
                if (count > 0) path.append(count);
                ans.add(path.toString());
            } else {
                helper(word, index + 1, count + 1, path, ans);
                if (count > 0) path.append(count);
                helper(word, index + 1, 0, path.append(word.charAt(index)), ans);
            }
            path.setLength(len);
        }
    }
}
