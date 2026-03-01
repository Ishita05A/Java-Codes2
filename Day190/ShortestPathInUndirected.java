package Day190;
import java.util.*;

public class ShortestPathInUndirected {
    static class Pair{
        int node;
        int dist;
        Pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static int[] findShortestDistance(int[][] mat,int src,int v){
        List<List<Integer>> adj = new ArrayList<>();
        int n = mat.length;
        for(int i = 0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            adj.get(mat[i][0]).add(mat[i][1]);
            adj.get(mat[i][1]).add(mat[i][0]);
        }
        int[] dist = new int[v];
        for(int i = 0;i<v;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
       
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        while(!q.isEmpty()){
            Pair top = q.poll();
            int node = top.node;
            int dis = top.dist;
            for(int it : adj.get(node)){
                if(dis+1 <dist[it]){
                    dist[it] = dis+1;
                    q.add(new Pair(it, dis+1));
                }
            }
            
        }
        for(int i = 0;i<v;i++){
                if(dist[i] == Integer.MAX_VALUE) 
                    dist[i] = -1;
        }
        return dist;
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
        int[] ans = findShortestDistance(arr, 0,9);
        display(ans);
        sc.close();
    }
    
}
