/**
 * Problem: Jump Game II
 * Description: You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 */
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int currReach = 0, currMax = 0, jumps = 0;

        for(int i = 0; i < n - 1; i++) {
            if(i + nums[i] > currMax) {
                currMax = i + nums[i];
            }
            if(i == currReach) {
                jumps++;
                currReach = currMax;
            }
        }
        return jumps;
    }
}