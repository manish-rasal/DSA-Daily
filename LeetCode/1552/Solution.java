/**
 * Problem: Magnetic Force Between Two Balls
 * Description: In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.
 *
 * Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
 *
 * Given the integer array position and the integer m. Return the required force.
 */
class Solution {
    private boolean isPossible(int[] position, int m, int mid) {
        int ballCount = 1;
        int prev = position[0];
        for(int i = 1; i < position.length; i++) {
            if(position[i] >= prev + mid) {
                ballCount++;
                prev = position[i];
            }
            if(ballCount == m) return true;
        }
        return ballCount == m;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int l = 1, r = position[n - 1] - position[0];
        int result = 0;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(isPossible(position, m, mid)) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}