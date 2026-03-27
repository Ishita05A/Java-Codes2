package Day203;

public class RatInAMaze3Dir {
    static int findMinPath_rec(int i,int j,int n){
        if(i == n-1 && j == n-1){
            return 0;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int diag = Integer.MAX_VALUE;
        if(i<n-1) {
            left = 1+findMinPath_rec(i+1, j, n);
        }
        if(j<n-1){
            right = 1+findMinPath_rec(i, j+1, n);
        }
        if(i<n-1 && j<n-1){
            diag = 1+findMinPath_rec(i+1, j+1, n);
        }
        return Math.min(diag, Math.min(left, right));
    }
    public static void main(String[] args) {
        System.out.println(findMinPath_rec(0, 0, 3));
    }
    
}
