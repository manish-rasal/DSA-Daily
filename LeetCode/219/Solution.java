/**
 * Problem: 219. Contains Duplicate II
 * Description: Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0, j = 0;
        HashSet<Integer> set = new HashSet<>();
        while(j < nums.length) {
            if(Math.abs(i - j) > k) {
                set.remove(nums[i]);
                i++;
            }
            if(set.contains(nums[j])) return true;
            set.add(nums[j]);
            j++;
        }
        return false;
    }
}