package Day165;

import java.util.*;
public class CycleDetectionBfs {
    static class Pair{
        int node;
        int parent;
        Pair(int node,int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    static boolean detect(int sr,List<List<Integer>> adj,int[] vis){
        Queue<Pair> q = new LinkedList<>();
        vis[sr] = 1;
        q.add(new Pair(sr, -1));
        while(!q.isEmpty()){
            Pair top = q.poll();
            int parent = top.parent;
            int node = top.node;
            for(int it: adj.get(node)){
                if(vis[it] == 0){
                    vis[it] = 1;
                    q.add(new Pair(it, node));
                }
                else{
                    if(parent != it) return true;
                }
            }
        }
        return false;
    }
    static boolean isCyclic(List<List<Integer>> ans,int v){
        int[] vis= new int[v];
        for(int i = 0;i<v;i++){
            if(vis[i] == 0){
                if(detect(i, ans, vis)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes");
        int n = sc.nextInt();
        System.out.println("Enter edges");
        int m = sc.nextInt();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            ans.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            ans.get(u).add(v);
            ans.get(v).add(u);
        }
        System.out.println(isCyclic(ans, n));
        sc.close();
    }   
}
