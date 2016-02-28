package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 2/28/16.
 */
public class Combinations {
    public class Solution {
        //C(n, k) = C(n-1, k-1) + C(n-1, k)
        public List<List<Integer>> combine(int n, int k) {
            if (n == k || k == 0) {
                List<List<Integer>> ans = new ArrayList();
                List<Integer> list = new ArrayList();
                for (int i = 1; i <= k; i++) {
                    list.add(i);
                }
                ans.add(list);
                return ans;
            }

            List<List<Integer>> ans = combine(n - 1, k);
            List<List<Integer>> lists = combine(n - 1, k - 1);
            for (List<Integer> l : lists) {
                l.add(n);
            }
            ans.addAll(lists);
            return ans;
        }
    }
}
