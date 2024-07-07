/**
 * Problem: Count Complete Tree Nodes
 * Description: Given the root of a complete binary tree, return the number of the nodes in the tree.
 *
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Design an algorithm that runs in less than O(n) time complexity.
 */
// Recursive:
class Solution {
    int count=0;
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        countNodes(root.left);
        count++;
        countNodes(root.right);
        return count;
    }
}
// Iterative:
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
    public int countNodes(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr == null) {
                continue;
            }
            result++;
            queue.add(curr.left);
            queue.add(curr.right);
        }
        return result;
    }
}