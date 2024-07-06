/**
 * Problem: Find the Minimum and Maximum Number of Nodes Between Critical Points
 * Description: A critical point in a linked list is defined as either a local maxima or a local minima.
 *
 * A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.
 *
 * A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.
 *
 * Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.
 *
 * Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between any two distinct critical points. If there are fewer than two critical points, return [-1, -1].
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        List<Integer> criticalNodes = new ArrayList<>();
        ListNode prev = head, curr = head.next;
        int i = 1;
        while(curr.next != null) {
            ListNode later = curr.next;
            if((curr.val > prev.val && curr.val > later.val) || (curr.val < prev.val && curr.val < later.val)) {
                criticalNodes.add(i);
            }
            prev = curr;
            curr = later;
            i++;
        }
        int n = criticalNodes.size();
        if(n > 1) {
            int minDist = Integer.MAX_VALUE;
            for(i = 1; i < n; i++) {
                minDist = Math.min(minDist, criticalNodes.get(i) - criticalNodes.get(i - 1));
            }
            result[0] = minDist;
            result[1] = criticalNodes.get(n - 1) - criticalNodes.get(0);
        }
        return result;
    }
}