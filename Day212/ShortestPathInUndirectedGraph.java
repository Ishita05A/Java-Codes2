package Day212;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import java.util.*;
public class ShortestPathInUndirectedGraph {
    static class Pair{
        int node;
        int step;
        Pair(int node,int step){
            this.node = node;
            this.step = step;
        }
    }
    static int[] shortestPath(List<List<Integer>> adj,int V){
        Queue<Pair> q = new LinkedList<>();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        q.add(new Pair(0, 0));
        dist[0] = 0;
        while(!q.isEmpty()){
            Pair top = q.poll();
            int node = top.node;
            int step = top.step;
            for(int it:adj.get(node)){
                if(dist[it]>step+1){
                    dist[it] = step+1;
                    q.add(new Pair(it, step+1));
                }
            }
        }
        return dist;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of nodes");
        int n = sc.nextInt();
        System.out.println("Enter no. of edges");
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        System.out.println("Enter elements");
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }
        int[] ans = shortestPath(adj, n);
        
    }
    
}
