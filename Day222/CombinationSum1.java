package Day222;
import java.util.*;
public class CombinationSum1 {
    static void helper(int[] arr,int k, int idx,int sum,List<Integer> a,List<List<Integer>> ans){
        if(idx == arr.length) return;
        if(sum == k){
            ans.add(new ArrayList<>(a));
            return;
        }
        if(sum + arr[idx] <= k){
            a.add(arr[idx]);
            helper(arr, k, idx, sum+arr[idx], a, ans);
            a.remove(a.size()-1);
        }
        helper(arr, k, idx+1, sum, a, ans);

    }
    static List<List<Integer>> combSum(int[] arr,int k){
        List<Integer> a = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(arr, k, 0,0, a, ans);
        return ans;

    }
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        System.out.println(combSum(arr, 7));
    }
    
}
