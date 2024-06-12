/**
 * Problem: Search in Rotated Sorted Array
 * Description: There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
class Solution {

    private int binarySearch(int[] nums, int l, int r, int target) {
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) r--;
            else l++;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int pivot = r;
        if(nums[l] > nums[r]) {
            while(l <= r) {
                pivot = l + (r - l) / 2;

                if(pivot == nums.length - 1 || pivot == 0) {
                    break;
                }
                else if(nums[pivot] > nums[pivot + 1] && nums[pivot] > nums[pivot - 1]) break;
                else if(nums[pivot] < nums[pivot + 1] && nums[0] > nums[pivot]) r = pivot;
                else l = pivot;
            }
        }

        if(target >= nums[0]) return binarySearch(nums, 0, pivot, target);
        else return binarySearch(nums, pivot + 1, nums.length - 1, target);
    }
}