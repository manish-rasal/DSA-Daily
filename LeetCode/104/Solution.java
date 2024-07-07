/**
 * Problem: Maximum Depth of Binary Tree
 * Description: Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result;
    private void depth(TreeNode root, int i) {
        if(root == null) return;
        result = Math.max(i + 1, result);
        depth(root.left, i + 1);
        depth(root.right, i + 1);
    }
    public int maxDepth(TreeNode root) {
        result = 0;
        depth(root, 0);
        return result;
    }
}