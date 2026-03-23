package Day201;
import java.util.*;
public class SubSetI {
    static void helper(List<Integer> ans,int[] arr,int idx,int sum){
        if(idx == arr.length){
            ans.add(sum);
            return;
        }
        helper(ans, arr, idx+1, sum);
        helper(ans, arr, idx+1, sum+arr[idx]);

    }
    static List<Integer> Subset(int[] arr){
        ArrayList<Integer>  ans = new ArrayList<>();
        helper(ans, arr, 0, 0);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr  = {5,2,1};
        System.out.println(Subset(arr));
    }
    
}
