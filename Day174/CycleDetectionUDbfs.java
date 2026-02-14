package Day174;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CycleDetectionUDbfs {
    static class Pair{
        int node;
        int parent;
        Pair(int node,int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    static boolean bfs(int[] vis,List<List<Integer>> adj,int node){
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
                else{
                    if(it != parent) return true;
                }
            }
        }
        return false;

    } 
    static boolean isCyclic(int v,List<List<Integer>> adj){
        int[] vis = new int[v];
        return bfs(vis, adj, 0);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes");
        int n = sc.nextInt();
        System.out.println("Enter edges");
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        System.out.println("Enter nodes");
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(isCyclic(n, adj));
        sc.close();
    }
    
}
