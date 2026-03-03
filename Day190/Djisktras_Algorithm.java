package Day190;
import java.util.*;

public class Djisktras_Algorithm {
    static  class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    static List<Integer> djisktraAlgo(int[][] mat, int n,int m){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++){
            adj.get(mat[i][0]).add(new Pair(mat[i][2], mat[i][1]));
            adj.get(mat[i][1]).add(new Pair(mat[i][2], mat[i][0]));
        }
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((x,y)->x.first-y.first);
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        for(int i = 0;i<=n;i++){
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        dist[1] = 0;
        q.add(new Pair(0, 1));
        while(!q.isEmpty()){
            Pair top = q.poll();
            int node = top.second;
            int wt = top.first;
            if(wt > dist[node]) continue;
            for(Pair it : adj.get(node)){
                int adjNode = it.second;
                int ewt = it.first;
                if(ewt+wt < dist[adjNode]){
                    dist[adjNode] = ewt+wt;
                    parent[adjNode] = node;
                    q.add(new Pair(ewt+wt, adjNode));
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(dist[n] == Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }
        int node = n;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of nodes");
        int n = sc.nextInt();
        System.out.println("Enter edges");
        int m = sc.nextInt();
        System.out.println("Enter elements ");
        int[][] arr = new int[m][3];
        for (int i = 0; i < m; i++) {
            for(int j = 0;j<3;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(djisktraAlgo(arr, n,m));
        sc.close();

    }
    
}
