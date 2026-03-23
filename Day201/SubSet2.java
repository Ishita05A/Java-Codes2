package Day201;
import java.util.*;
public class SubSet2 {
    static void helper(List<List<Integer>> ans,List<Integer> a,int[] arr,int idx){
        ans.add(new ArrayList<>(a));
        for(int i = idx;i<arr.length;i++){
            if(i>idx && arr[i] == arr[i-1]) continue;
            a.add(arr[i]);
            helper(ans, a, arr, i+1);
            a.remove(a.size()-1);
        }
    }
    static List<List<Integer>> subset2(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        Arrays.sort(arr);
        helper(ans,a , arr, 0);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        System.out.println(subset2(arr));
    }
    
}
