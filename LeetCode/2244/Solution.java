/**
 * Problem: Minimum Rounds to Complete All Tasks
 * Description: You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task. In each round, you can complete either 2 or 3 tasks of the same difficulty level.
 *
 * Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.
 */
class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int n = tasks.length;
        int rounds = 0;
        int count = 0;
        int i = 0;
        while(i < n) {
            int num = tasks[i];
            while(i < n && tasks[i] == num) {
                count++;
                i++;
            }
            if(count == 1) return -1;
            else {
                rounds += Math.ceil((double)count / 3);
                count = 0;
            }
        }
        return rounds;
    }
}