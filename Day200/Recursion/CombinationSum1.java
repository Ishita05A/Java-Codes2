package Day200.Recursion;

import java.util.*;

public class CombinationSum1 {
    static void helper(List<List<Integer>> ans, List<Integer> a, int[] arr, int sum, int idx) {
        if (idx == arr.length){
            if (sum == 0){
                ans.add(new ArrayList<>(a));
            }
            return;
        }
        if(arr[idx] <= sum) {
            a.add(arr[idx]);
            helper(ans, a, arr, sum-arr[idx], idx);
            a.remove(a.size()-1);
        }
        
        helper(ans, a, arr, sum, idx+1);
    }

    static List<List<Integer>> combinationSum(int[] arr, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        
        helper(ans,a , arr, k, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        System.out.println(combinationSum(arr, 7));
    }

}
