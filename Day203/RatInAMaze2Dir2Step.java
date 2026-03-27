package Day203;

public class RatInAMaze2Dir2Step {
    static int minPath_rec(int i,int j,int n){
        if(i == n-1 && j == n-1) return 0;
        int down = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(i<n-2) down = 1+minPath_rec(i+2, j, n);
        if(j<n-2) left = 1+minPath_rec(i, j+2, n);
        return Math.min(down, left);
    }
    public static void main(String[] args) {
        System.out.println(minPath_rec(0, 0, 4));
    }
    
}
