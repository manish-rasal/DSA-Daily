/**
 * Problem: Minimum Speed to Arrive on Time
 * Description: You are given a floating-point number hour, representing the amount of time you have to reach the office. To commute to the office, you must take n trains in sequential order. You are also given an integer array dist of length n, where dist[i] describes the distance (in kilometers) of the ith train ride.
 *
 * Each train can only depart at an integer hour, so you may need to wait in between each train ride.
 *
 * For example, if the 1st train ride takes 1.5 hours, you must wait for an additional 0.5 hours before you can depart on the 2nd train ride at the 2 hour mark.
 * Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel at for you to reach the office on time, or -1 if it is impossible to be on time.
 *
 * Tests are generated such that the answer will not exceed 107 and hour will have at most two digits after the decimal point.
 */
class Solution {
    private boolean canArrive(int[] dist, int mid, double hour) {
        double time = 0;
        int i;
        for(i = 0; i < dist.length - 1; i++) {
            time += Math.ceil((double) dist[i] / mid);
            if(time > hour) return false;
        }
        time += (double) dist[i] / mid;
        return time <= hour;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int r = 1000000000;
        int l = 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(canArrive(dist, mid, hour)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (canArrive(dist, l, hour))? l:-1;
    }
}