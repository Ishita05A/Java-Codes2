package Day169;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class DetectCycle_BFS {
    static class Pair{
        int node;
        int parent;
        Pair(int node,int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    static boolean bfs(List<List<Integer>> adj,int[] vis,int node){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        vis[node] = 1;
        while(!q.isEmpty()){
            Pair top = q.poll();
            node = top.node;
            int parent = top.parent;
            for(int it:adj.get(node)){
                if(vis[it] == 0){
                    vis[it] = 1;
                    q.add(new Pair(it, node));
                }
                else if(parent != it) return true;
            }
        }
        return false;
    }
    static boolean isCycle(List<List<Integer>> adj,int v){
        int[] vis = new int[v];
        for(int i = 0;i<v;i++){
            if(vis[i] == 0){
                if(bfs(adj, vis, i)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes");
        int n = sc.nextInt();
        System.out.println("Enter no. of edges");
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(isCycle(adj, n));
        sc.close();
    }
    
}
