package Day161;

import java.util.*;

public class bfs {
    public class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static List<Integer> bfs_Traversal(List<List<Integer>> arr,int v){
        boolean[] vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            int top = q.poll();
            ans.add(top);
            for(int it:arr.get(top)){
                if(vis[it] == false){
                    vis[it] = true;
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
        System.out.println("Enter no. of edges");
        int m = sc.nextInt();
        List<List<Integer>>  arr = new ArrayList<>();
        for(int i = 0;i<n;i++){
            arr.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            arr.get(u).add(v);
            arr.get(v).add(u);
        }
        System.out.println(bfs_Traversal(arr, n));
        sc.close();
        
    }    
}
