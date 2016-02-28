package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhuangda on 2/28/16.
 */
public class FactorCombinations {
    public class Solution {
        //@author: zhuangda
        public List<List<Integer>> getFactors(int n) {
            List<List<Integer>> ans = new ArrayList();

            if (n <= 1) return ans;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    int next = n / i;
                    List<List<Integer>> lists = getFactors(next);
                    lists.add(new ArrayList(Arrays.asList(next)));
                    for (List<Integer> list : lists) {
                        if (list.get(0) >= i) {
                            list.add(0, i);
                            ans.add(list);
                        }
                    }
                }
            }
            return ans;
        }

    }

    //optimization
    public class Solution2 {
        public List<List<Integer>> getFactors(int n) {
            List<List<Integer>> ans = new ArrayList();

            if (n < 4) return ans;
            helper(n, 2, new ArrayList(), ans);
            return ans;
        }

        private void helper(int n, int startFactor, List<Integer> path, List<List<Integer>> ans) {

            for (int i = startFactor; i*i <= n; i++) {
                if (n%i == 0) {
                    path.add(i);
                    helper(n/i, i, path, ans);
                    path.add(n/i);
                    ans.add(new ArrayList(path));
                    path.remove(path.size() - 1);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
