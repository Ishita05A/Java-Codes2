package Day192;

import java.util.*;
public class CheapestFlightWithKStops {
    static class Pair{
        int node;
        int wt;
        Pair(int node,int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    static class Tuple{
        int first;
        int second;
        int third;
        Tuple(int first,int second,int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    static int findCheapestCost(int n, int[][] mat,int src,int des, int k){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<mat.length;i++){
            adj.get(mat[i][0]).add(new Pair(mat[i][1], mat[i][2]));
        }
        int[] dist = new int[n];
        for(int i = 0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));
        dist[src] = 0;
        while(!q.isEmpty()){
            Tuple top = q.poll();
            int stop = top.first;
            int node = top.second;
            int dis = top.third;
            if(stop >  k) continue;
                for(Pair it : adj.get(node)){
                    int adjNode = it.node;
                    int wt = it.wt;
                    if(wt + dis <dist[adjNode] && stop <=k){
                        dist[adjNode] = wt + dis;
                        q.add(new Tuple(stop+1,adjNode, wt+dis));
                    }
                }
            
        }
        if(dist[des] == Integer.MAX_VALUE) return -1;
        return dist[des];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of rows");
        int n = sc.nextInt();
        System.out.println("Enter no. of columns");
        int m = sc.nextInt();
        System.out.println("Enter elements ");
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for(int j = 0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(findCheapestCost(4, arr, 0, 3, 1));
        sc.close();
    }
    
}
