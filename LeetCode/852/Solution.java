/**
 * Problem: Peak Index in a Mountain Array
 * Description: You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
 *
 * Return the index of the peak element.
 *
 * Your task is to solve it in O(log(n)) time complexity.
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            else if(arr[mid] > arr[mid + 1]) r = mid;
            else l = mid;
        }
        return -1;
    }
}