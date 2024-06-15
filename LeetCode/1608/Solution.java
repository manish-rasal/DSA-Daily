/**
 * Problem: Special Array With X Elements Greater Than or Equal X
 * Description: You are given an array nums of non-negative integers. nums is considered special if there exists a number x such that there are exactly x numbers in nums that are greater than or equal to x.
 *
 * Notice that x does not have to be an element in nums.
 *
 * Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.
 */
class Solution {
    private int numberOfGreaterElements(int[] nums, int mid) {
        int result = 0;
        for(int i: nums) {
            if(i >= mid) result++;
        }
        return result;
    }
    public int specialArray(int[] nums) {
        int n = nums.length;
        int l = 0, r = n;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int x = numberOfGreaterElements(nums, mid);
            if(mid == x) return x;
            else if(mid > x) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}