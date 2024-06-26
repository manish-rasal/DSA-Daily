/**
 * Problem: Check If Two String Arrays are Equivalent
 * Description: Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 *
 * A string is represented by an array if the array elements concatenated in order forms the string.
 */
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for(String s: word1)
            str1.append(s);
        for(String s: word2)
            str2.append(s);
        return str1.toString().equals(str2.toString());
    }
}