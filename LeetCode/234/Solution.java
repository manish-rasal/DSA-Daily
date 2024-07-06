/**
 * Problem: Palindrome Linked List
 * Description: Given the head of a singly linked list, return true if it is a
 * palindrome
 *  or false otherwise.
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
    private ListNode reverse(ListNode head) {
        if(head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        ListNode fast = head.next, slow = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow);
        while(slow != null) {
            if(head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}