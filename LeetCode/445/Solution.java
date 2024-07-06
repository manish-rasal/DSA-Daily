/**
 * Problem: Add Two Numbers II
 * Description: You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
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
    public StringBuilder addStrings(StringBuilder num1, StringBuilder num2) {
        StringBuilder result = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int n1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int n2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = n1 + n2 + carry;
            carry = sum / 10;
            result.append(sum % 10);

            i--;
            j--;
        }

        return result.reverse();
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        while(l1 != null && l2 != null) {
            num1.append(String.valueOf(l1.val));
            num2.append(String.valueOf(l2.val));
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            num1.append(String.valueOf(l1.val));
            l1 = l1.next;
        }
        while(l2 != null) {
            num2.append(String.valueOf(l2.val));
            l2 = l2.next;
        }
        StringBuilder sum = addStrings(num1, num2);
        return constructList(sum, 0);
    }
    private ListNode constructList(StringBuilder sum, int i) {
        if(i == sum.length()) return null;
        return new ListNode(sum.charAt(i) - '0', constructList(sum, i + 1));
    }
}