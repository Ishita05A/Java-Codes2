package Day222;
import java.util.*;
public class Subset1 {
    static void helper(int[] arr,int sum,int idx,List<Integer> ans){
        if(idx == arr.length){
            ans.add(sum);
            return;
        }
        helper(arr, sum, idx+1, ans);
        helper(arr, sum+arr[idx], idx+1, ans);
    }
    static List<Integer> subsetSum(int[] arr){
        List<Integer> ans = new ArrayList<>();
        helper(arr, 0, 0, ans);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr= {5,2,1};
        System.out.println(subsetSum(arr));
        
    }
    
}
