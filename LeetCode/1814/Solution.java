/**
 * Problem: Count Nice Pairs in an Array
 * Description: You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:
 *
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.
 */
class Solution {
    private int rev(int n) {
        StringBuilder str = new StringBuilder(String.valueOf(n));
        return Integer.parseInt(str.reverse().toString());
    }
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int MOD = 1000000007;
        for(int i: nums) {
            int num = i - rev(i);
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        long result = 0;
        for (int count : freq.values()) {
            result = (result + (long) count * (count - 1) / 2) % MOD;
        }
        return (int) result;
    }
}