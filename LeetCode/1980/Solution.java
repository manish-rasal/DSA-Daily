/**
 * Problem: Find Unique Binary String
 * Description: Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.
 */
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < nums.length; i++) {
            ans.append((nums[i].charAt(i) == '0')? '1':'0');
        }
        return ans.toString();
    }
}