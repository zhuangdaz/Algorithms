package com.betterman.algorithms.boston.tree;

import com.betterman.algorithms.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class ConstructBinaryTreePreorderInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, preorder.length - 1);
    }

    /**
     * the worst case for this: A tree that's not balanced but is just a straight line to the left.
     * Then inorder is the reverse of preorder, and already the cost of step 2, searching in inorder, is O(n^2) overall.
     *
     * @param preorder
     * @param inorder
     * @param preStart
     * @param inStart
     * @param inEnd
     * @return
     */
    private TreeNode helper(
            int[] preorder,
            int[] inorder,
            int preStart,
            int inStart,
            int inEnd
    ) {
        if (preStart == preorder.length || inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preStart]);
        int i = inStart;
        for (; i <= inEnd; i++) {
            if (inorder[i] == node.val) {
                break;
            }
        }

        node.left = helper(preorder, inorder, preStart + 1, inStart, i - 1);
        node.right = helper(preorder, inorder, preStart + i - inStart + 1, i + 1, inEnd);
        return node;
    }


    /**
     * Time: O(n)
     * Space: O(n)
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTreeWithMap(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return helperWithMap(preorder, inOrderMap, 0, 0, preorder.length - 1);
    }

    private TreeNode helperWithMap(
            int[] preorder,
            Map<Integer, Integer> inorder,
            int preStart,
            int inStart,
            int inEnd
    ) {
        if (preStart == preorder.length || inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preStart]);
        int i = inorder.get(node.val); // Index of current root in inorder

        node.left = helperWithMap(preorder, inorder, preStart + 1, inStart, i - 1);
        node.right = helperWithMap(preorder, inorder, preStart + i - inStart + 1, i + 1, inEnd);
        return node;
    }
}
