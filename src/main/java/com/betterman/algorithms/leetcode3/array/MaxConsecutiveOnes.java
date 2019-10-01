package com.betterman.algorithms.leetcode3.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by zhuangda on 7/19/17.
 */
public class MaxConsecutiveOnes {
    public static class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int res = 0, max = 0;

            for (int num : nums) {
                if (num == 0) {
                    if (res > max) {
                        max = res;
                    }
                    res = 0;
                } else {
                    res++;
                }
            }
            return res > max ? res : max;
        }

        public List<Integer> getRow(int rowIndex) {
            Integer[] row = new Integer[rowIndex + 1];
            Arrays.fill(row, 0);
            row[0] = 1;

            for (int i = 0; i <= rowIndex; i++) {
                for (int j = i; j > 0; j--) {
                    row[j] += row[j - 1];
                }
            }

            return Arrays.asList(row);
        }
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("anthony", "weiwei", "fifi");

        List<String> ret = strings.stream().filter(str -> !"anthony".equals(str)).collect(Collectors.toList());

        ret.forEach(System.out::println);

    }
}
