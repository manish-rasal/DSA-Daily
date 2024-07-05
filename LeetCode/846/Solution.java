/**
 * Problem: Hand of Straights
 * Description: Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
 *
 * Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.
 */
class Solution {
    public boolean isNStraightHand(int[] nums, int k) {
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