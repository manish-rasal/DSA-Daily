/**
 * Problem: Longest Subarray of 1's After Deleting One Element
 * Description: Given a binary array nums, you should delete one element from it.
 *
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 */
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        int result = 0, zeroCount = 0;
        while(j < n) {
            if(nums[j] == 0) zeroCount++;
            while(zeroCount > 1) {
                if(nums[i] == 0) zeroCount--;
                i++;
            }
            result = Math.max(result, j - i);
            j++;
        }
        return result;
    }
}