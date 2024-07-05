/**
 * Problem: Divide Array in Sets of K Consecutive Numbers
 * Description: Given an array of integers nums and a positive integer k, check whether it is possible to divide this array into sets of k consecutive numbers.
 *
 * Return true if it is possible. Otherwise, return false.
 */
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return false;

        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        while (!freqMap.isEmpty()) {
            int first = freqMap.firstKey();
            for (int i = first; i < first + k; i++) {
                if (!freqMap.containsKey(i)) return false;
                int count = freqMap.get(i);
                if (count == 1) {
                    freqMap.remove(i);
                } else {
                    freqMap.put(i, count - 1);
                }
            }
        }

        return true;
    }
}