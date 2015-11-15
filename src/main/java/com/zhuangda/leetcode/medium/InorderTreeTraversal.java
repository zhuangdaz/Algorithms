package com.zhuangda.leetcode.medium;

import com.zhuangda.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhuangda on 11/11/15.
 */
public class InorderTreeTraversal {
    public class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList();

            if (root == null) {
                return ret;
            }

            Stack<TreeNode> s = new Stack<TreeNode>();
            TreeNode n = root;
            while (s.size() > 0 || n != null) {
                if (n != null) {
                    s.push(n);
                    n = n.left;
                } else {
                    n = s.pop();
                    ret.add(n.val);
                    n = n.right;
                }
            }

            return ret;
        }
    }
}
