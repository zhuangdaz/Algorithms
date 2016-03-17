package com.betterman.algorithms.leetcode2.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 3/13/16.
 */
public class GeneralizedAbbreviation {
    public class Solution {
        public List<String> generateAbbreviations(String word) {
            List<String> ans = new ArrayList();
            helper(ans, word, 0, 0, new StringBuilder());
            return ans;
        }

        private void helper(List<String> ans, String word, int index, int count, StringBuilder sb) {
            int len = sb.length();
            if (index == word.length()) {
                if (count > 0) sb.append(count);
                ans.add(sb.toString());
            } else {
                helper(ans, word, index + 1, count + 1, sb);
                if (count > 0) sb.append(count);
                sb.append(word.charAt(index));
                helper(ans, word, index + 1, 0, sb);
            }
            sb.setLength(len);
        }
    }
}
