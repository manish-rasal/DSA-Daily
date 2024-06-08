/**
 * Problem: Excel Sheet Column Number
 * Description: Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
 */
class Solution {
    public int titleToNumber(String title) {
        int n = title.length();
        int result = 0;
        for(int i = 0; i < n; i++) {
            result += Math.pow(26, n - 1 - i) * (title.charAt(i) - 'A' + 1);
        }
        return result;
    }
}