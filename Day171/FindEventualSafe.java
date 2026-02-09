package Day171;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class FindEventualSafe {
    static List<Integer> eventualSafeNode(int V,List<List<Integer>> adj){
        List<List<Integer>> adjRev = new ArrayList<>();
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<V;i++){
            adjRev.add(new ArrayList<>());
        }
        for(int i = 0;i<V;i++){
            for(int it:adj.get(i)){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        for(int i = 0;i<V;i++){
            if(indegree[i] == 0) q.add(i);
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int it: adjRev.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        Collections.reverse(topo);
        return topo;
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
            
        }
        System.out.println(eventualSafeNode(n, adj));
        sc.close();
    }
    
}
