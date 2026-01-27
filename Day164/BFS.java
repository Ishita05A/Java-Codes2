package Day164;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    static List<Integer> bfs(int V,List<List<Integer>> adj){
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        visited[0] = true;
        q.add(0);
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int it : adj.get(node)){
                if(visited[it] == false){
                    visited[it] = true;
                    q.add(it);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of nodes");
        int n = sc.nextInt();
        System.out.println("Enter no. of Edges");
        int m = sc.nextInt();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<n+1;i++){
            ans.add(new ArrayList<>());
        }
        for(int j = 0;j<m;j++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            ans.get(u).add(v);
            ans.get(v).add(u);
        }
        System.out.println(bfs(n, ans));
        sc.close();
    }
    
}
