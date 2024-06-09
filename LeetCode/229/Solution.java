/**
 * Problem: 229. Majority Element II
 * Description: Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int maj1 = Integer.MIN_VALUE;
        int maj2 = Integer.MAX_VALUE;
        int count1 = 0, count2 = 0;
        for(int i: nums) {
            if(i == maj1) {
                count1++;
            } else if(i == maj2) {
                count2++;
            } else if(count1 == 0) {
                maj1 = i;
                count1 = 1;
            } else if(count2 == 0) {
                maj2 = i;
                count2 = 1;
            } else  {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i: nums) {
            if(i == maj1) count1++;
            if(i == maj2) count2++;
        }
        List<Integer> ans = new ArrayList<>();
        if (count1 > nums.length / 3) ans.add(maj1);
        if (count2 > nums.length / 3) ans.add(maj2);
        return ans;
    }
}