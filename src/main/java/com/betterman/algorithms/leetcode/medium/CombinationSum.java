package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhuangda on 12/27/15.
 */
public class CombinationSum {
    public class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList();
            Arrays.sort(candidates);
            helper(candidates, 0, target, new ArrayList(), res);
            return res;
        }


        private void helper(int[] candidates, int start, int target, List<Integer> combinationSoFar, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList(combinationSoFar));
            } else {
                for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
                    combinationSoFar.add(candidates[i]);
                    helper(candidates, i, target - candidates[i], combinationSoFar, res);
                    combinationSoFar.remove(combinationSoFar.size() - 1);
                }
            }
        }
    }
}
