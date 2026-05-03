package Day218;

import java.util.Scanner;
import java.util.*;
public class DetectACycle {
    static boolean helper(List<List<Integer>> adj, int node, int parent, int[] vis){
        vis[node] = 1;
        for(int it: adj.get(node)){
            if(vis[it] == 0){
                if(helper(adj, it, node,vis) == true) return true;
            }
            else if(it != parent) return true;
        }
        return false;
    }
    static boolean isCyclic(List<List<Integer>> adj,int v){
        int[] vis = new int[v];
        for(int i = 0;i<v;i++){
            if(vis[i] == 0){
                if(helper(adj,i,-1,vis) == true) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
    
}
