package Day164;

import java.util.*;
public class DFS {
    static void helper(int node,List<List<Integer>> adj,boolean[] visited,List<Integer> ans){
        visited[node] = true;
        ans.add(node);
        for(int it : adj.get(node)){
            if(visited[it] == false){
                helper(it, adj, visited, ans);  
            }
        }
    }
    static List<Integer> dfs(int v, List<List<Integer>> adj){
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[v];
        helper(0, adj, visited, ans);
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
        System.out.println(dfs(n, ans));
        sc.close();
    }
    
}
