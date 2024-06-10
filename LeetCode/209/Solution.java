/**
 * Problem: Minimum Size Subarray Sum
 * Description: Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int i = 0, j = 0, n = nums.length;
        int sum = 0;
        while (j < n) {
            sum += nums[j];
            while (sum >= target) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}