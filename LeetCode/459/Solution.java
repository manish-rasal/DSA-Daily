/**
 * Problem: Repeated Substring Pattern
 * Description: Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                String sub = s.substring(0, i);
                int repeatCount = n / i;
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < repeatCount; j++) {
                    str.append(sub);
                }
                if (str.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}