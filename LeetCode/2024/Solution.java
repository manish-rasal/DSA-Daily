/**
 * Problem: Maximize the Confusion of an Exam
 * Description: A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).
 *
 * You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you are given an integer k, the maximum number of times you may perform the following operation:
 *
 * Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
 * Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.
 */
class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int i = 0, j = 0;
        int maxLen = 0;
        int n = s.length();
        int countF = 0;
        while (j < n) {
            if(s.charAt(j) == 'F') countF++;
            while(countF > k) {
                if(s.charAt(i) == 'F') countF--;
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        i = 0;
        j = 0;
        int countT = 0;
        while (j < n) {
            if(s.charAt(j) == 'T') countT++;
            while (countT > k) {
                if(s.charAt(i) == 'T') countT--;
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}