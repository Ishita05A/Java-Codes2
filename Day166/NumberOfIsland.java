package Day166;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfIsland {
    static class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    static void bfs(int[][] mat, int[][] vis,int row,int col){
        Queue<Pair> q = new LinkedList<>();
        vis[row][col] = 1;
        q.add(new Pair(row, col));
        while(!q.isEmpty()){
            
            for(int i = -1;i<=1;i++){
                for(int j = -1;j<=1;j++){
                    if(mat[i][j] == 1 && vis[i][j] == 0){
                        q.add(new Pair(i, j));
                    }
                }
            }
        }
        
    }
    static void noOfIsland(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){

            }
        }
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
    }
    
}
