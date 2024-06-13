/**
 * Problem: Kth Missing Positive Number
 * Description: Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 *
 * Return the kth positive integer that is missing from this array.
 */
class Solution {
    public int findKthPositive(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int missingCount = nums[mid] - (mid + 1);
            if(missingCount < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l + k;
    }
}