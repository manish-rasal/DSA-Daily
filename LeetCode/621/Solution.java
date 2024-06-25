/**
 * Problem: Task Scheduler
 * Description: You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
 *
 * Return the minimum number of intervals required to complete all tasks.
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char c: tasks) {
            freq[c - 'A']++;
        }

        Arrays.sort(freq);

        int maxFreq = freq[25];
        int gaddhe = maxFreq - 1;
        int idleSlots = gaddhe * n;

        for(int i = 24; i >= 0; i--) {
            idleSlots -= Math.min(freq[i], gaddhe);
        }

        if(idleSlots > 0) {
            return tasks.length + idleSlots;
        }

        return tasks.length;
    }
}