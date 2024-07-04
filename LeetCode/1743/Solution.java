/**
 * Problem: Restore the Array From Adjacent Pairs
 * Description: There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.
 *
 * You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.
 *
 * It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
 *
 * Return the original array nums. If there are multiple solutions, return any of them.
 */
class Solution {
    public int[] restoreArray(int[][] adj) {
        int n = adj.length + 1;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] edge: adj) {
            int x = edge[0];
            int y = edge[1];

            List<Integer> xAdj = map.getOrDefault(x, new ArrayList<>());
            xAdj.add(y);
            map.put(x, xAdj);
            List<Integer> yAdj = map.getOrDefault(y, new ArrayList<>());
            yAdj.add(x);
            map.put(y, yAdj);
        }

        int root = 0;
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            if(entry.getValue().size() == 1) {
                root = entry.getKey();
                break;
            }
        }
        int[] result = new int[n];
        dfs(result, root, 0, map, Integer.MAX_VALUE);
        return result;
    }

    private void dfs(int[] result, int root, int i, HashMap<Integer, List<Integer>> map, int prev) {
        result[i] = root;
        for(int neighbour: map.get(root)) {
            if(neighbour != prev) {
                dfs(result, neighbour, i + 1, map, root);
            }
        }
    }
}