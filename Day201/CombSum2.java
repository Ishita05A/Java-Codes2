package Day201;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class CombSum2 {
    static void helper(List<List<Integer>> ans,List<Integer> a,int[] arr,int sum,int idx){
        if(sum == 0){
            ans.add(new ArrayList<>(a));
            return;
        }
        for(int i = idx;i<arr.length;i++){
            if(i>idx && arr[i] == arr[i-1]) continue;
            if(arr[i] > sum) break;
            a.add(arr[i]);
            helper(ans, a, arr, sum-arr[i], i+1);
            a.remove(a.size()-1);
        }
    }

    static List<List<Integer>> combinationSum2(int[] arr,int target){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        Arrays.sort(arr);
        helper(ans,a , arr, target, 0);
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2};
        System.out.println(combinationSum2(arr, 5));
    }
}
