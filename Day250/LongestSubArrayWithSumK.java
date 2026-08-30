package Day250;
import java.util.*;
public class LongestSubArrayWithSumK {
    static int longest(int[] nums,int k){
        int n = nums.length;
        int max = 0;
        int left = 0;
        int sum = 0;
        for(int right = 0;right<n;right++){
            sum += nums[right];
            while (sum > k) {
                sum-=nums[left];
                left++;
            }
            if(sum == k){
                max = Math.max(max, right-left+1);
            }
        }
        return max;
    }
    static int longestSubArray(int[] arr){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int n = arr.length;
        int sum = 0;
        int max = 0;
        mp.put(0, -1);
        for(int i = 0;i<n;i++){
            sum += arr[i];
            if(sum == 0) max = i+1;
            if(mp.containsKey(sum)){
                max = Math.max(max,i-mp.get(sum));
            }
            mp.putIfAbsent(sum,i);
        }
        return max;

    }
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println(longest(nums, k));  
        int arr[] = {9, -3, 3, -1, 6, -5} ; 
        System.out.println(longestSubArray(arr));
    }
    
}
