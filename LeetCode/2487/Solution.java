/**
 * Problem: Remove Nodes From Linked List
 * Description: You are given the head of a linked list.
 *
 * Remove every node which has a node with a greater value anywhere to the right side of it.
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
    public ListNode removeNodes(ListNode head) {
        List<Integer> nodeValues = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            nodeValues.add(curr.val);
            curr = curr.next;
        }
        for(int i = nodeValues.size() - 2; i >= 0; i--) {
            nodeValues.set(i, Math.max(nodeValues.get(i + 1), nodeValues.get(i)));
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        curr = head;
        int i = 0;
        while(curr != null) {
            if(curr.val == nodeValues.get(i)) {
                temp.next = curr;
                temp = temp.next;
            }
            curr = curr.next;
            i++;
        }
        return dummy.next;
    }
}