package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/8/15.
 */
public class SimplifyPath {
    public class Solution {
        public String simplifyPath(String path) {
            String[] dirs = path.split("/");
            int len = 0;
            for (int i = 0; i < dirs.length; i++) {
                String dir = dirs[i];
                if (dir.equals("..") && len > 0) {
                    len--;
                } else if (dir.equals(".") || dir.equals("..") || dir.isEmpty()) {
                    continue;
                } else {
                    dirs[len++] = dir;
                }
            }

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < len; i++) {
                sb.append("/").append(dirs[i]);
            }

            if (sb.length() == 0) sb.append("/");
            return sb.toString();
        }
    }
}
