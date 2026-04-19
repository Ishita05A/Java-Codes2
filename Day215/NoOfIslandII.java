package Day215;
import java.util.*;
class DisjoinSet{
    int[] rank;
    int[] parent;
    public DisjoinSet(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        for(int i = 0;i<n+1;i++){
            parent[i] = i;
        }
    }
    int findParent(int node){
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }
    void unionByRank(int u,int v){
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
            parent[ulp_u] = ulp_v;
            rank[ulp_v]++;
        }
    }

}
public class NoOfIslandII {
    static List<Integer> noOfIsland(int n,int m, int[][] A){
        int[][] vis = new int[n][m];
        DisjoinSet ds = new DisjoinSet(n*m);
        List<Integer> ans = new ArrayList<>();
        int cnt = 0;
        int[] drow = {1,-1,0,0};
        int [] dcol = {0,0,-1,1};
        for(int i = 0;i<A.length;i++){
            int row = A[i][0];
            int col = A[i][1];
            if(vis[row][col] == 1){
                ans.add(cnt);
                continue;
            }
            vis[row][col] = 1;
            cnt++;
            for(int j = 0;j<4;j++){
                int nrow = row+drow[j];
                int ncol = col+dcol[j];
                if(nrow>=0 && nrow<n && ncol >= 0 && ncol <m){
                    if(vis[nrow][ncol] == 1){
                        if(ds.findParent(nrow*m+ncol) != ds.findParent(row*m+col)){
                            cnt--;
                            ds.unionByRank(nrow*m+ncol, row*m+col);
                        }
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
        System.out.println(noOfIsland(n, m, A)); 
    }
    
}
