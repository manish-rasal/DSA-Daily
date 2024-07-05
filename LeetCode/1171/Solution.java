/**
 * Problem: Remove Zero Sum Consecutive Nodes from Linked List
 * Description: Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
 *
 * After doing so, return the head of the final linked list.  You may return any such answer.
 *
 *
 *
 * (Note that in the examples below, all sequences are serializations of ListNode objects.)
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

    public static List<Integer> removeZeroSumSubsequence(List<Integer> list) {

        while (true) {
            int[] prefixSum = new int[list.size() + 1];
            prefixSum[0] = 0;
            for (int i = 0; i < list.size(); i++) {
                prefixSum[i + 1] = prefixSum[i] + list.get(i);
            }

            int startIndex = -1, endIndex = -1;
            for (int i = 0; i < prefixSum.length; i++) {
                for (int j = i + 1; j < prefixSum.length; j++) {
                    if (prefixSum[j] - prefixSum[i] == 0) {
                        startIndex = i;
                        endIndex = j - 1;
                        break;
                    }
                }
                if (startIndex != -1) {
                    break;
                }
            }

            if (startIndex == -1) {
                break;
            }

            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (i < startIndex || i > endIndex) {
                    temp.add(list.get(i));
                }
            }
            list = temp;
        }

        return list;
    }
    public ListNode removeZeroSumSublists(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }

        List<Integer> list1 = removeZeroSumSubsequence(list);
        if(list1.size() == 0) return null;
        ListNode result = new ListNode(list1.get(list1.size() - 1), null);

        for(int i = list1.size() - 2; i >= 0; i--) {
            result = new ListNode(list1.get(i), result);
        }
        return result;
    }
}