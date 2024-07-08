/**
 * Problem: Diameter of Binary Tree
 * Description: Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
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
    private int diameter = 0;
    private int depth(TreeNode root) {
        if(root == null) return 0;

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        diameter = Math.max(diameter, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }
}