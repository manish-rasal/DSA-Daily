/**
 * Problem: Validate Binary Search Tree
 * Description: Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left
 * subtree
 *  of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
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
    private List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        class Traverse {
            Traverse(TreeNode root) {
                if(root.left != null) {
                    new Traverse(root.left);
                }
                result.add(root.val);
                if(root.right != null) {
                    new Traverse(root.right);
                }
            }
        }
        if(root == null) return result;
        new Traverse(root);
        return result;
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrderTraversal = inOrder(root);
        for(int i = 1; i < inOrderTraversal.size(); i++){
            if(inOrderTraversal.get(i) <= inOrderTraversal.get(i - 1)) return false;
        }
        return true;
    }
}