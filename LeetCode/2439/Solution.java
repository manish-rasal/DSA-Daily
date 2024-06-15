/**
 * Problem: Minimize Maximum of Array
 * Description: You are given a 0-indexed array nums comprising of n non-negative integers.
 *
 * In one operation, you must:
 *
 * Choose an integer i such that 1 <= i < n and nums[i] > 0.
 * Decrease nums[i] by 1.
 * Increase nums[i - 1] by 1.
 * Return the minimum possible value of the maximum integer of nums after performing any number of operations.
 */
class Solution {
    private boolean isValid(int[] nums, int mid, int n) {
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        for(int i = 0; i < n - 1; i++) {
            if(arr[i] > mid) return false;

            long buffer = mid - arr[i];
            arr[i + 1] = arr[i + 1] - buffer;
        }
        return arr[n - 1] <= mid;
    }
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = Arrays.stream(nums).max().getAsInt();
        int result = l;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(isValid(nums, mid, n)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}