/**
 * Problem: Find Players With Zero or One Losses
 * Description: You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.
 *
 * Return a list answer of size 2 where:
 *
 * answer[0] is a list of all players that have not lost any matches.
 * answer[1] is a list of all players that have lost exactly one match.
 * The values in the two lists should be returned in increasing order.
 *
 * Note:
 *
 * You should only consider the players that have played at least one match.
 * The testcases will be generated such that no two matches will have the same outcome.
 */
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> losses = new HashMap<>();
        for(int[] match: matches) {
            if(!losses.containsKey(match[0])) {
                losses.put(match[0], 0);
            }
            losses.put(match[1], losses.getOrDefault(match[1], 0) + 1);
        }
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> noLose = new ArrayList<>();
        List<Integer> oneLose = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: losses.entrySet()) {
            if(entry.getValue() == 0) noLose.add(entry.getKey());
            if(entry.getValue() == 1) oneLose.add(entry.getKey());
        }
        Collections.sort(noLose);
        Collections.sort(oneLose);
        answer.add(noLose);
        answer.add(oneLose);
        return answer;
    }
}