package Day234;
import java.util.*;

public class SubSetSum {

    static void helper(int[] arr, int idx, List<Integer> a,int sum){
        if(!a.contains(sum)){
            a.add(sum);
        }
        if(idx == arr.length) return;
        helper(arr, idx+1, a, sum);
        helper(arr, idx+1, a, sum+arr[idx]);
    }
    static List<Integer> subset(int[] arr){
        List<Integer> a = new ArrayList<>();
        helper(arr, 0, a, 0);
        return a;
    }
    public static void main(String[] args) {
        int[] arr = {5,2,1};
        System.out.println(subset(arr));
    }
}
