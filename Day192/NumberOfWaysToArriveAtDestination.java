package Day192;
import java.util.*;
public class NumberOfWaysToArriveAtDestination {

    static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    static int noOfWays(int[][] mat,int n){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<mat.length; i++){
            adj.get(mat[i][0]).add(new Pair(mat[i][1], mat[i][2]));
            adj.get(mat[i][1]).add(new Pair(mat[i][0], mat[i][2]));
        }
        long[] dist = new long[n];
        for(int i = 0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        int[] ways = new int[n];
        ways[0] = 1;
        dist[0] = 0;
        int mod = (int)1e9+7;
       PriorityQueue<Pair> q = new PriorityQueue<>((x,y)->Long.compare(x.first,y.first));
        q.add(new Pair(0, 0));
        while(!q.isEmpty()){
            Pair top = q.poll();
            int dis = top.first;
            int node = top.second;
            if(dis > dist[node]) continue;
            for(Pair it : adj.get(node)){
                int adjNode = it.first;
                int wt = it.second;
                if(wt+dis < dist[adjNode]){
                    dist[adjNode] = wt + dis;
                    q.add(new Pair((int)dist[adjNode], adjNode));
                    ways[adjNode] = ways[node];
                }
                else if(wt + dis == dist[adjNode]){
                    ways[adjNode]= (ways[node] + ways[adjNode])%mod;
                }
            }
        }
        return ways[n-1];
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
        System.out.println(noOfWays(arr, 2));
        sc.close();
    }
    
}
