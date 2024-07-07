/**
 * Problem: Symmetric Tree
 * Description: Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null) {
                continue;
            } else if(left == null || right == null) {
                return false;
            } else if(left.val != right.val) {
                return false;
            } else {
                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);
            }
        }
        return true;
    }
}