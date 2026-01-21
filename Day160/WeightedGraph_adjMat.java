package Day160;

import java.util.ArrayList;
import java.util.Scanner;

public class WeightedGraph_adjMat {
    static class Pair{
    int edge;
    int wt;
    Pair(int edge,int wt){
        this.edge = edge;
        this.wt = wt;
    }
}
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of nodes");
        int n = sc.nextInt();
        System.out.println("Enter edges");
        int m = sc.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Pair>[] arr = new ArrayList[n+1];
        for(int i = 0;i<=n;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();
            arr[u].add(new Pair(v, wt));
            arr[v].add(new Pair(u, wt));
        }
        for(int i = 1;i<n;i++){
            for(int j = 0;j<arr[i].size();j++){
                System.out.printf("%d %d",arr[i].get(j).edge,arr[i].get(j).wt );
            }
            System.out.println();
        }
        sc.close();
    }
    
}
