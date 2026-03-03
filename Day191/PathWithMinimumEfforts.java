package Day191;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PathWithMinimumEfforts {
    static class Pair{
        int first;
        int second;
        int third;
        Pair(int first,int second,int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    static int pathWithMinEfforts(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int[][] dist = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->(a.first - b.first));
        q.add(new Pair(0, 0, 0));
        int[] drow = {1,-1,0,0};
        int[] dcol = {0,0,1,-1};
        while(!q.isEmpty()){
            Pair top = q.poll();
            int diff = top.first;
            int row = top.second;
            int col = top.third;
            if(row == n-1 && col == m-1) return diff;
            for(int i = 0;i<4;i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol <m &&
                     mat[nrow][ncol] - mat[row][col] < dist[nrow][ncol]){
                        int dif = mat[nrow][ncol] -mat[row][col];
                        dist[nrow][ncol] = dif;
                        q.add(new Pair(dif, nrow, ncol));
                }
            }
        }
        return -1;
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
        System.out.println(pathWithMinEfforts(arr));
        sc.close();
    }
    
}
