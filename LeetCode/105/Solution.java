/**
 * Problem: Construct Binary Tree from Preorder and Inorder Traversal
 * Description: Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
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
    private int preorderIndex = 0;
    private HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
    private TreeNode buildTreeHelper(int[] preorder, int left, int right) {
        if(left > right) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTreeHelper(preorder, left, inorderIndexMap.get(rootVal) - 1);
        root.right = buildTreeHelper(preorder, inorderIndexMap.get(rootVal) + 1, right);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }

}