/**
 * Problem: Equal Row and Column Pairs
 * Description: Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
 *
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 */
class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<List<Integer>, Integer> map = new HashMap<>();

        for (int[] row : grid) {
            List<Integer> key = new ArrayList<>();
            for (int num : row) {
                key.add(num);
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int n = grid[0].length;
        int result = 0;

        for (int j = 0; j < n; j++) {
            List<Integer> column = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                column.add(grid[i][j]);
            }
            if (map.containsKey(column)) {
                result += map.get(column);
            }
        }

        return result;
    }
}