package Day236;

import java.util.*;

public class NoOfIslands {
    static int[] drow = { 0, 0, 1, -1 };
    static int[] dcol = { 1, -1, 0, 0 };

    static void dfs(int[][] grid, int[][] vis, int row, int col, List<String> list, int baseRow, int baseCol) {
        vis[row][col] = 1;
        list.add((row - baseRow) + "," + (col - baseCol));
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                dfs(grid, vis, nrow, ncol, list, baseRow, baseCol);
            }
        }
    }

    static int countIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<List<String>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    List<String> list = new ArrayList<>();
                    dfs(grid, vis, i, j, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 1, 1 }
        };
        System.out.println(countIsland(grid));
    }

}
