/**
 * Problem: Partition List
 * Description: Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
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
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;

        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode list1 = dummy1;
        ListNode list2 = dummy2;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                list1.next = temp;
                list1 = list1.next;
            } else {
                list2.next = temp;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        list2.next = null;

        list1.next = dummy2.next;

        return dummy1.next;
    }
}