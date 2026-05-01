package Day217;
import java.util.*;
class DisjoinSet{
    int[] rank;
    int[] parent;
    public DisjoinSet(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        for(int i = 0;i<=n;i++){
            parent[i] = i;
        }
    }
    int findParent(int node){
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }
    void unionByRank(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return;
        if(rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = ulp_v;
        }
        else if(rank[ulp_v] < rank[ulp_u]){
            parent[ulp_v] = ulp_u;
        }
        else{
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
}
public class NoOfIslandII {
    
    static List<Integer> findIsland(int n,int m, int[][] arr){
        DisjoinSet ds = new DisjoinSet(n*m);
        List<Integer> ans = new ArrayList<>();
        int q = arr.length;
        int cnt = 0;
        int[][] vis = new int[n][m];
        int[] drow = {0,0,-1,1};
        int[] dcol = {1,-1,0,0};
        for(int i = 0;i<q;i++){
                int row = arr[i][0];
                int col = arr[i][1];
                if(vis[row][col] == 1){
                    ans.add(cnt);
                    continue;
                } 
                vis[row][col] = 1;
                cnt++;
                for(int j = 0;j<4;j++){
                    int nrow  = row + drow[j];
                    int ncol = col + dcol[j];
                    if(nrow >=0 && nrow < n && ncol >=0 && ncol<m &&  vis[nrow][ncol] == 1){
                        int node = n*row+col;
                        int adjNode = n*nrow+ncol;
                        if(ds.findParent(adjNode) != ds.findParent(node)){
                            cnt--;
                            ds.unionByRank(node, adjNode);
                        }
                    }
                } 
                ans.add(cnt);
        }
        return ans;

        
    }
    public static void main(String[] args) {
         int n = 4;
         int m = 5;
         int[][] A = {{1,1},{0,1},{3,3},{3,4}};
         System.out.println(findIsland(n, m, A));
    }
}
