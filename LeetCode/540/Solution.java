/**
 * Problem: Single Element in a Sorted Array
 * Description: You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 *
 * Return the single element that appears only once.
 *
 * Your solution must run in O(log n) time and O(1) space.
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        while(i <= j) {
            int mid = i + (j - i) / 2;
            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == n - 1 || nums[mid + 1] > nums[mid])) return nums[mid];
            if((nums[mid - 1] == nums[mid] && mid % 2 == 0) || (nums[mid + 1] == nums[mid] && mid % 2 != 0)) j = mid - 1;
            else i = mid + 1;
        }
        return -1;
    }
}