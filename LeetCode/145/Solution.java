/**
 * Problem: Binary Tree Postorder Traversal
 * Description: Given the root of a binary tree, return the postorder traversal of its nodes' values.
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        class Traverse {
            Traverse(TreeNode root) {
                if(root.left != null) {
                    new Traverse(root.left);
                }
                if(root.right != null) {
                    new Traverse(root.right);
                }
                result.add(root.val);
            }
        }
        if(root == null) return result;
        new Traverse(root);
        return result;
    }
}