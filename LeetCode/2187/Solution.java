/**
 * Problem: Minimum Time to Complete Trips
 * Description: You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.
 *
 * Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the current trip. Also, each bus operates independently; that is, the trips of one bus do not influence the trips of any other bus.
 *
 * You are also given an integer totalTrips, which denotes the number of trips all buses should make in total. Return the minimum time required for all buses to complete at least totalTrips trips.
 */
class Solution {
    private boolean possible(int[] time, long mid, int totalTrips) {
        long possibleTrips = 0;
        for(int i: time) {
            possibleTrips += mid / i;
            if (possibleTrips >= totalTrips) {
                return true;
            }
        }
        return possibleTrips >= totalTrips;
    }
    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
        int min = Arrays.stream(time).min().getAsInt();
        long l = 1, r = (long) min * totalTrips;

        while(l < r) {
            long mid = l + (r - l) / 2;
            if(possible(time, mid, totalTrips)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}