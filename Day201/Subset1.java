package Day201;
import java.util.*;
public class Subset1 {
    static void helper(int[] arr,List<Integer> ans,int idx, int sum){
        if(idx == arr.length){
            ans.add(sum);
            return;
        }
        helper(arr, ans, idx+1, sum+arr[idx]);
        helper(arr, ans, idx+1, sum);
    }
    static List<Integer> subSet(int[] arr){
        List<Integer> ans = new ArrayList<>();
        helper(arr, ans, 0, 0);
        Collections.sort(ans);
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = {5,2,1};
        System.out.println(subSet(arr));
    }
    
}
