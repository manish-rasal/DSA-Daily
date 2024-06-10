/**
 * Problem: Reverse Vowels of a String
 * Description: Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 */
class Solution {
    public String reverseVowels(String s) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int i = 0, j = s.length() - 1;
        StringBuilder str = new StringBuilder(s);
        while(i < j) {
            if(vowels.contains(s.charAt(i)) && vowels.contains(s.charAt(j))) {
                str.setCharAt(i, s.charAt(j));
                str.setCharAt(j, s.charAt(i));
            } else if(vowels.contains(s.charAt(i))) {
                j--;
                continue;
            } else if(vowels.contains(s.charAt(j))) {
                i++;
                continue;
            }
            i++;
            j--;
        }
        return str.toString();
    }
}