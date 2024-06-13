/**
 * Problem: Successful Pairs of Spells and Potions
 * Description: You are given two positive integer arrays spells and potions, of length n and m respectively, where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.
 *
 * You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.
 *
 * Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.
 */
class Solution {
    private int findLeastPostion(int[] potions, int spell, long success) {
        int l = 0, r = potions.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if((long)potions[mid] * spell >= success) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return ((long)potions[l] * spell >= success) ? l: potions.length;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];

        for(int i = 0; i < n; i++) {
            int j = findLeastPostion(potions, spells[i], success);
            pairs[i] = m - j;
        }
        return pairs;
    }
}