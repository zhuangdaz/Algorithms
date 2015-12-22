package com.betterman.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 12/21/15.
 */

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p>
 * For example, given k = 3,
 * Return [1,3,3,1].
 * <p>
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangleII {
    public class Solution {

        //Key: iteratively update the array from the END to the BEGINNING.
        public List<Integer> getRow(int rowIndex) {
            int[] lastRow = new int[rowIndex + 1];

            lastRow[0] = 1;
            for (int i = 1; i <= rowIndex; i++) {
                for (int j = i; j > 0; j--) {
                    lastRow[j] += lastRow[j - 1];
                }
            }


            List<Integer> row = new ArrayList();
            for (int num : lastRow) {
                row.add(num);
            }
            return row;
        }
    }
}
