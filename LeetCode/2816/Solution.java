/**
 * Problem: Double a Number Represented as a Linked List
 * Description: You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
 *
 * Return the head of the linked list after doubling it.
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
    private StringBuilder addition(StringBuilder num) {
        int i = num.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while(i >= 0 || carry != 0) {
            int sum = 2 * ((i >= 0)? num.charAt(i) - '0': 0) + carry;
            result.append(sum % 10);
            carry = sum / 10;
            i--;
        }
        return result.reverse();
    }
    private ListNode constructList(StringBuilder num, int i) {
        if(i == num.length()) return null;
        return new ListNode(num.charAt(i) - '0', constructList(num, i + 1));
    }
    public ListNode doubleIt(ListNode head) {
        StringBuilder num = new StringBuilder();
        ListNode curr = head;
        while(curr != null) {
            num.append(String.valueOf(curr.val));
            curr = curr.next;
        }
        StringBuilder sum = addition(num);
        return constructList(sum, 0);
    }
}