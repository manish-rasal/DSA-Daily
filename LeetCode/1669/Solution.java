/**
 * Problem: Merge In Between Linked Lists
 * Description: You are given two linked lists: list1 and list2 of sizes n and m respectively.
 *
 * Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
 *
 * The blue edges and nodes in the following figure indicate the result:
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int currentIndex = 0;
        ListNode insert = list1, head = list1;

        while(list1 != null) {
            if(currentIndex == a - 1) {
                insert = list1;
            }
            if(currentIndex == b + 1) {
                break;
            }
            list1 = list1.next;
            currentIndex++;
        }
        insert.next = list2;
        while(list2.next != null) {
            list2 = list2.next;
        }
        list2.next = list1;
        return head;
    }
}