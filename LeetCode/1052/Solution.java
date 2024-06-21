/**
 * Problem: Grumpy Bookstore Owner
 * Description: There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store. You are given an integer array customers of length n where customers[i] is the number of the customer that enters the store at the start of the ith minute and all those customers leave after the end of that minute.
 *
 * On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.
 *
 * When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.
 *
 * The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can only use it once.
 *
 * Return the maximum number of customers that can be satisfied throughout the day.
 */
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int result = 0;
        int additional = 0, count = 0;
        int i = 0, j = 0;
        while(j < n) {
            if(grumpy[j] == 0) {
                result += customers[j];
            } else {
                count += customers[j];
            }

            if(j - i + 1 == minutes) {
                additional = Math.max(additional, count);
                if(grumpy[i] == 1) {
                    count -= customers[i];
                }
                i++;
            }
            j++;
        }
        return result + additional;
    }
}