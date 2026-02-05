package Day168;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottonOranges {
    static class Pair{
        int row;
        int col;
        int tm;
        Pair(int row,int col,int tm){
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }
    static int minTime(int[][] mat){
        Queue<Pair> q = new LinkedList<>();
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;
        int cntFresh = 0;
        int t = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
                if(mat[i][j] == 1) cntFresh++;
            }
        }
        int[] drow = {0,0,-1,1};
        int[] dcol = {1,-1,0,0};
        while(!q.isEmpty()){
            Pair top = q.poll();
            int row = top.row;
            int col = top.col;
            int tm = top.tm;
            t = Math.max(t,tm);
            for(int i = 0;i<4;i++){
                    int nrow = row+drow[i];
                    int ncol = col+dcol[i];
                    if(nrow >=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                        cnt++;
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol, tm+1));
                    }
            }
        }
        if(cnt != cntFresh) return -1;
        return t;
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
        System.out.println(minTime(arr));
        sc.close();
    }
    
}
