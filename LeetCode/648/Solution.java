/**
 * Problem: Replace Words
 * Description: In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word derivative. For example, when the root "help" is followed by the word "ful", we can form a derivative "helpful".
 *
 * Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root, replace it with the root that has the shortest length.
 *
 * Return the sentence after the replacement.
 */
class Solution {
    private String findRoot(StringBuilder word, HashSet<String> dict) {
        for(int i = 1; i < word.length(); i++) {
            String root = word.substring(0, i).toString();
            if(dict.contains(root)) return root;
        }
        return word.toString();
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> dict = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(String word: words) {
            result.append(findRoot(new StringBuilder(word), dict)).append(" ");
        }
        return result.toString().trim();
    }
}