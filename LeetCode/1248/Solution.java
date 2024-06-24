/**
 * Problem: Count Number of Nice Subarrays
 * Description: Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 */
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int i = 0, j = 0;
        int n = nums.length;
        int oddCount = 0, result = 0, count = 0;
        while(j < n) {
            if(nums[j] % 2 != 0) {
                oddCount++;
                count = 0;
            }
            while (oddCount == k) {
                count++;
                if(nums[i] % 2 != 0) oddCount--;
                i++;
            }
            result += count;
            j++;
        }
        return result;
    }
}