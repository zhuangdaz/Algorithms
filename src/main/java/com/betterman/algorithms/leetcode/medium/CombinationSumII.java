package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhuangda on 12/27/15.
 */
public class CombinationSumII {
    public class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList();
            Arrays.sort(candidates);
            helper(candidates, 0, target, new ArrayList(), res);
            return res;
        }

        private void helper(int[] candidates, int start, int target, List<Integer> curr, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList(curr));
            } else {
                for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
                    curr.add(candidates[i]);
                    helper(candidates, i + 1, target - candidates[i], curr, res);
                    curr.remove(curr.size() - 1);

                    while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) i++;
                }
            }
        }
    }
}
