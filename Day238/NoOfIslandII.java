package Day238;

import java.util.*;

public class NoOfIslandII {
    static class DisJointSet {
        int[] rank;
        int[] parent;
        int[] size;

        DisJointSet(int n) {
            rank = new int[n + 1];
            parent = new int[n + 1];
            size = new int[n + 1];
            Arrays.fill(size, 1);
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

        }

        int findParent(int node) {
            if (parent[node] == node)
                return node;
            return parent[node] = findParent(parent[node]);
        }

        void unionByRank(int u, int v) {
            int p_u = findParent(u);
            int p_v = findParent(v);
            if (rank[p_u] > rank[p_v]) {
                parent[p_v] = parent[p_u];
            } else if (rank[p_u] < rank[p_v]) {
                parent[p_u] = parent[p_v];
            } else {
                parent[p_v] = p_u;
                rank[p_u]++;
            }

        }

        void unionBySize(int u, int v) {
            int p_u = findParent(u);
            int p_v = findParent(v);
            if (size[p_u] > size[p_v]) {
                parent[p_v] = parent[p_u];
                size[p_u] += size[p_v];
            } else {
                parent[p_u] = parent[p_v];
                size[p_v] += size[p_u];
            }
        }
    }

    static List<Integer> countIsland(int n, int m, int k, int[][] mat) {
        int[][] vis = new int[n][m];
        DisJointSet ds = new DisJointSet(n * m);
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        for (int[] it : mat) {
            int row = it[0];
            int col = it[1];
            if (vis[row][col] == 1) {
                continue;
            } else {
                vis[row][col] = 1;
                cnt++;
            }
            int[] rr = { 1, -1, 0, 0 };
            int[] cc = { 0, 0, -1, 1 };
            for (int i = 0; i < 4; i++) {
                int nrow = row + rr[i];
                int ncol = col + cc[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    if (vis[nrow][ncol] == 1) {
                        if (ds.findParent(row * m + col) != ds.findParent(nrow * m + ncol)) {
                            ds.unionByRank(row * m + col, nrow * m + ncol);
                            cnt--;
                        }
                    }
                }
            }
            ans.add(cnt);

        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] operators = { { 1, 1 }, { 0, 1 }, { 3, 3 }, { 3, 4 } };

        System.out.println(countIsland(n, m, operators.length, operators));
    }

}
