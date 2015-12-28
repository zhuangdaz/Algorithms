package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 12/27/15.
 */
public class CombinationSumIII {
    public class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            int[] candidates = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
            List<List<Integer>> res = new ArrayList();
            helper(candidates, 0, n, new ArrayList(), res, k);
            return res;
        }

        private void helper(int[] candidates, int start, int target, List<Integer> curr, List<List<Integer>> res, int cnt) {
            if (target == 0 && curr.size() == cnt) {
                res.add(new ArrayList(curr));
            } else if (target > 0 && curr.size() < cnt){
                for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
                    curr.add(candidates[i]);
                    helper(candidates, i + 1, target - candidates[i], curr, res, cnt);
                    curr.remove(curr.size() - 1);

                    while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) i++;
                }
            }
        }
    }
}
