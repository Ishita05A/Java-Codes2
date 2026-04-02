package Day206;
import java.util.Arrays;

public class SubsetSumEqualtoK {
    static boolean isSubsetPresent_rec(int[] arr,int idx,int target){
        if(target == 0) return true;
        if(idx == 0){
            return arr[idx] == target;
        }
        boolean notPick = isSubsetPresent_rec(arr, idx-1, target);
        boolean pick = false;
        if(target>=arr[idx]) pick = isSubsetPresent_rec(arr, idx-1, target-arr[idx]);
        return pick || notPick;
    }
    static boolean isSubsetPresent_memo(int[] arr,int idx,int target,int[][] dp){
        if(target == 0) return true;
        if(idx == 0) return arr[idx] == target;
        if(dp[idx][target] != -1) return dp[idx][target] == 1;
        boolean notPick = isSubsetPresent_memo(arr, idx-1, target, dp);
        boolean pick = false;
        if(target >= arr[idx]) pick = isSubsetPresent_memo(arr, idx-1, target-arr[idx], dp);
        dp[idx][target] = (pick || notPick )? 1:0;
        return pick || notPick;
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 2};
        System.out.println(isSubsetPresent_rec(arr, arr.length-1, 6));
        int[][] dp = new int[5][6+1];
        for(int i = 0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(isSubsetPresent_memo(arr, arr.length-1, 6, dp));
    }
    
}
