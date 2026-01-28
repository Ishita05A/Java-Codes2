package Day164;

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
    static int orangeRotting(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int cntFresh = 0;
        int cnt = 0;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 2) {
                    vis[i][j] = 2;
                    q.add(new Pair(i, j, 0));
                }
                else vis[i][j] = 0;
                if(mat[i][j] == 1) cntFresh++; 
            }
        }
        int tm = 0;
        int[] drow = {-1,1,0,0};
        int[] dcol = {0,0,-1,1};
        while(!q.isEmpty()){
            Pair top = q.poll();
            int row = top.row;
            int col = top.col;
            int t = top.tm;
            tm = Math.max(tm, t);
            for(int i = 0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow<n && nrow >=0 && ncol>=0 && ncol<m &&  mat[nrow][ncol] == 1 && vis[nrow][ncol] != 2){
                    vis[nrow][ncol] = 2;
                    q.add(new Pair(nrow, ncol, t+1));
                    cnt++;
                }
                
            }
        }
        if(cnt != cntFresh) return -1;
        return tm;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows");
        int r = sc.nextInt();
        System.out.println("Enter columns");
        int c = sc.nextInt();
        int[][] mat = new int[r][c];
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(orangeRotting(mat));
        sc.close();

    }
    
}
