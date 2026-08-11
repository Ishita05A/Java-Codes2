package Day237;

import java.util.Arrays;

public class DisJointSet {
    int[] rank;
    int[] parent;
    int[] size;
    public DisJointSet(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        size = new int[n+1];
        Arrays.fill(size, 1);
        for(int i = 1;i<=n;i++){
            parent[i] = i;
        }
        
    }
    int findParent(int node){
        if(parent[node] == node) return node;
        return parent[node] = findParent(node);
    }

    void unionByRank(int u,int v){
        int p_u = findParent(u);
        int p_v = findParent(v);
        if(rank[p_u] > rank[p_v]){
            parent[p_v] = parent[p_u];
        }
        else if(rank[p_u] < rank[p_v]){
            parent[p_u] = parent[p_v];
        }
        else{
            parent[p_v] = p_u;
            rank[p_u]++;
        }

    }
    void unionBySize(int u,int v){
        int p_u = findParent(u);
        int p_v = findParent(v);
        if(size[p_u] > size[p_v]){
            parent[p_v] = parent[p_u];
            size[p_u] += size[p_v];
        }
        else{
            parent[p_u] = parent[p_v];
            size[p_v] += size[p_u];
        }
    }

    public static void main(String[] args) {
        DisJointSet ds = new DisJointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);
    }
    
}
