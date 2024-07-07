/**
 * Problem: Binary Tree Inorder Traversal
 * Description: Given the root of a binary tree, return the inorder traversal of its nodes' values.
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        class Traverse {
            Traverse(TreeNode currentNode) {

                if(currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                result.add(currentNode.val);
                if(currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return result;
    }
}