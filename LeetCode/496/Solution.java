/**
 * Problem: Next Greater Element I
 * Description: The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 *
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 *
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
 *
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];

            while(!st.isEmpty() && st.peek() <= num) {
                st.pop();
            }

            if(st.isEmpty()) {
                map.put(num, -1);
            } else {
                map.put(num, st.peek());
            }

            st.push(num);
        }
        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}