/**
 * Problem: Binary Trees With Factors
 * Description: Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
 *
 * We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.
 *
 * Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.
 */
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long mod = 1_000_000_007;
        HashMap<Integer, Long> map = new HashMap<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            long count = 1;  // Initialize the count with 1 for the current element as a single node tree.
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {  // Check if arr[j] is a factor of arr[i]
                    int right = arr[i] / arr[j];
                    if (map.containsKey(right)) {
                        count = (count + map.get(arr[j]) * map.get(right)) % mod;
                    }
                }
            }
            map.put(arr[i], count);
        }

        long result = 0;
        for (long value : map.values()) {
            result = (result + value) % mod;
        }
        return (int) result;
    }
}