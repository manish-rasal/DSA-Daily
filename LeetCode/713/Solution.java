/**
 * Problem: Subarray Product Less Than K
 * Description: Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int i = 0, j = 0;
        int product = 1;
        int count = 0;

        while(j < nums.length) {
            product *= nums[j];

            while(product >= k) {
                product /= nums[i];
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }
}