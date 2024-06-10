/**
 * Problem: Binary Subarrays With Sum
 * Description: Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
 *
 * A subarray is a contiguous part of the array.
 */
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int i = 0, j = 0;
        int windowSum = 0;
        int count = 0;
        int zeroCount = 0;
        while(j < n) {
            windowSum += nums[j];

            while (i < j && (nums[i] == 0 || windowSum > goal)) {

                if(nums[i] == 0) zeroCount++;
                else zeroCount = 0;
                windowSum -= nums[i];
                i++;
            }

            if(windowSum == goal) {
                count += 1 + zeroCount;
            }
            j++;
        }
        return count;
    }
}