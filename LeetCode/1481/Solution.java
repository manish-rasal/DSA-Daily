/**
 * Problem: Least Number of Unique Integers after K Removals
 * Description: Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
 */
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i: arr) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        List<Integer> values = new ArrayList<>(freq.values());
        Collections.sort(values);

        int deletedElements = 0;
        int i;
        for(i = 0; i < values.size(); i++) {
            if(deletedElements + values.get(i) > k) break;
            deletedElements += values.get(i);
        }
        return values.size() - i;
    }
}