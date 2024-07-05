/**
 * Problem: Swapping Nodes in a Linked List
 * Description: You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode first, second, fast = dummy, slow = dummy;
        for(int i = 0; i < k; i++) {
            fast = fast.next;
        }
        first = fast;
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        second = slow;
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
        return head;
    }
}