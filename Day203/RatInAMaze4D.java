package Day203;

public class RatInAMaze4D {
    static int min = Integer.MAX_VALUE;
    static void dfs(int i, int j, int n, int steps, boolean[][] visited){

        if (i == n - 1 && j == n - 1) {
            min = Math.min(min, steps);
            return;
        }
        visited[i][j] = true;

        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];

            if (ni >= 0 && nj >= 0 && ni < n && nj < n && !visited[ni][nj]) {
                dfs(ni, nj, n, steps + 1, visited);
            }
        }
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        int n = 4;
        boolean[] visited = new boolean[n];

    }
    
}
