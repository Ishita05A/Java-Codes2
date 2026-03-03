package Day191;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortesDistanceInBinarymaze {
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
    static int findMinDistance(int[][] mat,int[] source,int[] destination){
        int n = mat.length;
        int m = mat[0].length;
        int[][] dist = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, source[0], source[1]));
        int[] drow = {1,-1,0,0};
        int[] dcol = {0,0,-1,1};
        while(!q.isEmpty()){
            Pair top = q.poll();
            int dis = top.first;
            int row = top.second;
            int col = top.third;
            for(int i = 0;i<4;i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >=0 && nrow <n && ncol>=0 && ncol<m && dis + 1 < dist[nrow][ncol]){
                    if(nrow == destination[0] && ncol == destination[1]){
                        return dis+1;
                    }
                    dist[nrow][ncol] = dis+1;
                    q.add(new Pair(dis+1, nrow, ncol));
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
        System.out.println(findMinDistance(arr, new int[] {0,1}, new int[] {2,2}));
        sc.close();
    }
    
}
