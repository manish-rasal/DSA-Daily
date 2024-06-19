/**
 * Problem: Minimum Number of Days to Make m Bouquets
 * Description: You are given an integer array bloomDay, an integer m and an integer k.
 *
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
 *
 * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
 *
 * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
 */
class Solution {
    private boolean canMakeBouqets(int[] bloomDay, int m, int k, int mid) {
        int bouquets = 0, flowers = 0;
        for(int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] <= mid) {
                flowers++;
                if(flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
            if(bouquets >= m) return true;
        }
        return bouquets >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int l = 1, r = Integer.MAX_VALUE - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(canMakeBouqets(bloomDay, m, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (canMakeBouqets(bloomDay, m, k, l))? l:-1;
    }
}