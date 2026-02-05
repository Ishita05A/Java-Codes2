package Day168;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    static void bfs(List<List<Integer>> adj,int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[] vis = new int[v+1]; 
        vis[1] = 1;
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int top = q.poll();
            ans.add(top);
            for(int num : adj.get(top)){
                if(vis[num] == 0){
                     q.add(num);
                     vis[num] = 1;
                }
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes");
        int n = sc.nextInt();
        System.out.println("Enter no. of edges");
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        bfs(adj,n);
        sc.close();
    }
    
}
