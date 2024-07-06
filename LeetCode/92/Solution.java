/**
 * Problem: Reverse Linked List II
 * Description: Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Create a dummy node to handle edge cases where left == 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move the `prev` pointer to the node just before the `left` position
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // The `start` pointer points to the first node of the sublist to be reversed
        ListNode start = prev.next;
        // The `then` pointer points to the node that will be reversed
        ListNode then = start.next;

        // Reverse the sublist from `left` to `right`
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }
        return dummy.next;
    }
}