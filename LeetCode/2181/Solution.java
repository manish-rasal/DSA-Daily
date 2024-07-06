/**
 * Problem: Merge Nodes in Between Zeros
 * Description: You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.
 *
 * For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.
 *
 * Return the head of the modified linked list.
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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy, curr = head;
        int mergeSum = 0;
        while(curr != null) {
            mergeSum += curr.val;
            if(curr.val == 0 && mergeSum > 0) {
                temp.next = new ListNode(mergeSum);
                temp = temp.next;
                mergeSum = 0;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}