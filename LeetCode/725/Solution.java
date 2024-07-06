/**
 * Problem: Split Linked List in Parts
 * Description: Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
 *
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.
 *
 * The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.
 *
 * Return an array of the k parts.
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode curr = head;
        while(curr != null) {
            length++;
            curr = curr.next;
        }
        int nodesPerPart = length / k;
        int extraNodes = length % k;
        ListNode[] result = new ListNode[k];
        curr = head;
        for(int i = 0; i < k; i++) {
            int n = nodesPerPart + ((extraNodes > 0)? 1:0);
            extraNodes--;
            ListNode partHead = curr;
            while(n - 1 > 0 && curr != null) {
                curr = curr.next;
                n--;
            }
            if(curr != null) {
                ListNode nextPartHead = curr.next;
                curr.next = null;
                curr = nextPartHead;
            }
            result[i] = partHead;
        }
        return result;
    }
}