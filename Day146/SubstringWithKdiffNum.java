package Day146;

import java.util.HashMap;
import java.util.Scanner;

public class SubstringWithKdiffNum {
    static int subarraysWithKDistinct(int[] nums,int k){
        int cnt = 0;
        for(int i = 0;i<nums.length;i++){
            HashMap<Integer,Integer> mp = new HashMap<>();
            for(int j = i;j<nums.length;j++){
                mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
                if(mp.size() == k) cnt++;
                else if(mp.size()>k) break;
            }
        }
        return cnt;
    }
    static int subarrayWithKDistinct_optimized(int[] nums,int k){
        int cnt = 0;
        int l = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int r = 0;r<nums.length;r++){
            
            mp.put(nums[r],mp.getOrDefault(nums[r], 0)+1);
            while(mp.size()>k){
                mp.put(nums[l], mp.getOrDefault(nums[l],0)-1);
                if(mp.get(nums[l])==0) mp.remove(nums[l]);
                l++;
            }
            if(mp.size()<=k) cnt+=(r-l+1);
        }
        return cnt;
    }
    static int SubstringWithKdiff_optimized(int[] nums,int k){
        return subarrayWithKDistinct_optimized(nums, k)-subarrayWithKDistinct_optimized(nums, k-1);
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(subarraysWithKDistinct(arr, 2));
        System.out.println(SubstringWithKdiff_optimized(arr, 2));
        sc.close();
    }
    
}
