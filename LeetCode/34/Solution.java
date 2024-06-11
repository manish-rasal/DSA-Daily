/**
 * Problem: Find First and Last Position of Element in Sorted Array
 * Description: Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int[] result = new int[2];
        Arrays.fill(result, -1);
        while(i <= j) {
            int mid = i + (j - i) / 2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid - 1] < target) {
                    result[0] = mid;
                    break;
                } else {
                    j = mid - 1;
                }
            } else if(nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int mid = i + (j - i) / 2;
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid + 1] > target) {
                    result[1] = mid;
                    break;
                } else {
                    i = mid + 1;
                }
            } else if(nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return result;
    }
}