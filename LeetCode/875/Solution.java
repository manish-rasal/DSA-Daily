/**
 * Problem: Koko Eating Bananas
 * Description: Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
class Solution {
    private boolean canEatBananas(int[] piles, int h, int mid) {
        int timeTaken = 0;
        for (int i : piles) {
            timeTaken += (i + mid - 1) / mid;
            if (timeTaken > h) return false;
        }
        return timeTaken <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int l = 1, r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canEatBananas(piles, h, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}