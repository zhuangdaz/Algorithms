package com.betterman.algorithms.leetcode.easy;

import java.util.*;

/**
 * Created by zhuangda on 12/5/15.
 */
public class GroupShiftedStrings {
    public class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            Map<String, List<String>> map = new HashMap();
            Arrays.sort(strings);
            for (String str : strings) {
                StringBuffer sb = new StringBuffer();
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length - 1; i++) {
                    if (chars[i] - chars[i + 1] < 0) {
                        sb.append(chars[i] - chars[i + 1] + 26);
                    } else {
                        sb.append(chars[i] - chars[i + 1]);
                    }
                    sb.append(",");
                }
                String key = sb.toString();
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList());
                }

                map.get(key).add(str);
            }
            return new ArrayList(map.values());
        }
    }


}
