/**
 * Problem: Minimum Increment to Make Array Unique
 * Description: You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.
 *
 * Return the minimum number of moves to make every value in nums unique.
 *
 * The test cases are generated so that the answer fits in a 32-bit integer.
 */
class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int prev = nums[0];
        int result = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] <= prev) {
                prev++;
                result += prev - nums[i];
            } else {
                prev = nums[i];
            }
        }
        return result;
    }
}