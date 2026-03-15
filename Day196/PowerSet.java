package Day196;
import java.util.*;
public class PowerSet {
    static List<List<Integer>> powerSet(int[] arr){
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                List<Integer> a = new ArrayList<>();
                for(int k = i;k<=j;k++){
                    a.add(arr[k]);
                }
                ans.add(a);
            }  
        }
        ans.add(new ArrayList<>());
        return ans;
    }
    static List<List<Integer>> powerSet_optimized(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        int subSet = 1<<n;
        for(int num = 0 ; num<subSet;num++){
            List<Integer> a = new ArrayList<>();
            for(int i = 0;i<n;i++){
                if(((num & (1<<i)) ) != 0){
                    a.add(arr[i]);
                }
            }
            ans.add(a);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(powerSet(arr));
        System.out.println(powerSet_optimized(arr));
    }
    
}
