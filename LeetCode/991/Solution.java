/**
 * Problem: Broken Calculator
 * Description: There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:
 *
 * multiply the number on display by 2, or
 * subtract 1 from the number on display.
 * Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.
 */
class Solution {
    public int brokenCalc(int startValue, int target) {
        int steps = 0;
        while(target != startValue) {
            if(startValue > target) return steps + startValue - target;
            if(target % 2 != 0) {
                target += 1;
            } else {
                target /= 2;
            }
            steps++;
        }
        return steps;
    }
}