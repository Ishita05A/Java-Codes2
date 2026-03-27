package Day203;

public class RatInAMaze2D1or2Step {
    static int minDist_rec(int i,int j,int n){
        if(i == n-1 && j == n-1) return 0;
        int down1 = Integer.MAX_VALUE;
        int down2 = Integer.MAX_VALUE;
        int right1 = Integer.MAX_VALUE;
        int right2 = Integer.MAX_VALUE;
        if(i<n-1) down1 = 1+ minDist_rec(i+1, j, n);
        if(i<n-2) down2 = 1+minDist_rec(i+2, j, n);
        if(j<n-1) right1 = 1+minDist_rec(i, j+1, n);
        if(j<n-2) right2 = 1+minDist_rec(i, j+2, n);
        return Math.min(Math.min(right1, right2), Math.min(down1, down2));
    }
    public static void main(String[] args) {
        System.out.println(3);
    }
    
}
