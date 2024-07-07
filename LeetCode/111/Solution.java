/**
 * Problem: Minimum Depth of Binary Tree
 * Description: Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
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
    private void solve(TreeNode root, int i) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            result = Math.min(result, i + 1);
            return;
        }
        solve(root.left, i + 1);
        solve(root.right, i + 1);
    }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        result = Integer.MAX_VALUE;
        solve(root, 0);
        return result;
    }
}