package Day199;

public class coinProblem {
    static int count(int idx,int[] arr,int target){
        if(idx == arr.length){
            if(target == 0) return 1;
            else return 0;
        }
        int notPick = count(idx+1, arr, target);
        int pick = 0;
        if(arr[idx] <= target){
            pick = count(idx, arr, target-arr[idx]);
        }
        return pick +notPick;
    }
    static int countWays(int idx, int[] coins, int target) {
        
        if (target == 0) return 1;

        int count = 0;

        for (int i = idx; i < coins.length; i++) {
            if (coins[i] <= target) {
                count += countWays(i, coins, target - coins[i]); 
            }
        }

        return count;
    }
    static int solve(int target, int[] coins) {
        if (target == 0) return 0;
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= target) {
                int res = solve(target - coins[i], coins);
                if (res != Integer.MAX_VALUE) {
                    mini = Math.min(mini, 1 + res);
                }
            }
        }

        return mini;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,5,10,50};
        System.out.println(count(0, arr, 65));
    }
    
}
