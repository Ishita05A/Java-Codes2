package Day203;

public class RatInAMaze3D2S {
    static int minPath_rec(int i,int j,int n){
        if(i == n-1 && j == n-1){
            return 0;
        }
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int diag = Integer.MAX_VALUE;
        if(i<n-2) down = 1+minPath_rec(i+2, j, n);
        if(j<n-2) right = 1+minPath_rec(i, j+2, n);
        if(i<n-2 && j<n-2) diag = 1+minPath_rec(i+2, j+2, n);
        return Math.min(Math.min(down, right), diag);
    }
    public static void main(String[] args) {
        System.out.println(minPath_rec(0, 0, 3));
    }
    
}
