package Day187;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class DetectACycle_bfs {
    static boolean isCyclic(List<List<Integer>> adj,int v){
        int[] indegree = new int[v];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<v;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<v;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return ans.size() != adj.size();
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
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }
        System.out.println(isCyclic(adj, n));
        sc.close();
    }
    
}
