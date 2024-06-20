/**
 * Problem: Maximum 69 Number
 * Description: You are given a positive integer num consisting only of digits 6 and 9.
 *
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 */
class Solution {
    public int maximum69Number (int num) {
        StringBuilder number = new StringBuilder(String.valueOf(num));
        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) != '9') {
                number.setCharAt(i, '9');
                return Integer.parseInt(number.toString());
            }
        }
        return num;
    }
}