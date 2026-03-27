package Day203;

import java.util.LinkedList;
import java.util.Queue;

public class RatInAMaze2Dir {
    static class Pair{
        int i;
        int j;
        int step;
        Pair(int i,int j,int step){
            this.i = i;
            this.j = j;
            this.step = step;
        }
    }
    static int min = Integer.MAX_VALUE;
    static int minPath_bfs(int n){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 0));
        while(!q.isEmpty()){
            Pair top = q.poll();
            int i = top.i;
            int j = top.j;
            int step = top.step;
            if(i == n-1 && j == n-1) return step;
            if(i<n-1) q.add(new Pair(i+1, j, step+1));
            if(j<n-1) q.add(new Pair(i, j+1, step+1));
        }
        return -1;
    }
    static void minPath_dfs(int i,int j,int n,int step){
        if(i == n-1 && j == n-1){
            min = Math.min(min, step);
            return;
        }
        if(i<n-1){
            minPath_dfs(i+1, j, n, step+1);
        }
        if(j<n-1){
            minPath_dfs(i, j+1, n, step+1);
        }

    }
    static int minPath_rec(int i,int j,int n){
        if(i == n-1 && j == n-1){
            return 0;
        }
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(i<n-1) {
            down = 1+minPath_rec(i+1, j, n);
        } 
        if(j<n-1){
            right = 1+ minPath_rec(i, j+1, n);
        }
        return Math.min(down, right);
    }
    static void usingRec(int i,int j,int n,String path){
        if(i == n-1 && j == n-1){
            System.out.println(path);
            return;
        }
        if(i<n-1) usingRec(i+1, j, n, path+'D');
        if(j<n-1) usingRec(i, j+1, n, path+'R');
    }
    public static void main(String[] args) {
        // usingRec(0, 0, 3,"");
        System.out.println(minPath_rec(0, 0, 3));
        minPath_dfs(0, 0, 3, 0);
        System.out.println(min);
        System.out.println(minPath_bfs(3));

    }
    
}
