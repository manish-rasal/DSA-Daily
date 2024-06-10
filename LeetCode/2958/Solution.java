/**
 * Problem: Length of Longest Subarray With at Most K Frequency
 * Description: You are given an integer array nums and an integer k.
 *
 * The frequency of an element x is the number of times it occurs in an array.
 *
 * An array is called good if the frequency of each element in this array is less than or equal to k.
 *
 * Return the length of the longest good subarray of nums.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int i = 0, j = 0;
        int result = 0;
        while(j < n) {
            frequencyMap.put(nums[j], frequencyMap.getOrDefault(nums[j], 0) + 1);

            while(i < j && frequencyMap.get(nums[j]) > k) {
                frequencyMap.put(nums[i], frequencyMap.get(nums[i]) - 1);
                if(frequencyMap.get(nums[i]) == 0) frequencyMap.remove(nums[i]);
                i++;
            }
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }
}