package com.betterman.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 12/21/15.
 */
public class PascalTriangle {
    public class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList();

            if (numRows <= 0) return res;

            for (int i = 0; i < numRows; i++) {
                List<Integer> row = new ArrayList();

                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        List<Integer> lastRow = res.get(i - 1);
                        row.add(lastRow.get(j - 1) + lastRow.get(j));
                    }
                }

                res.add(row);
            }
            return res;
        }
    }
}
