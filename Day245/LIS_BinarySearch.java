package Day245;

import java.util.*;
public class LIS_BinarySearch {
    static int lis(int[] nums){
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        for(int i = 1;i<n;i++){
            if(nums[i] > ans.get(ans.size()-1)){
                ans.add(nums[i]);
            }
            else{
                int idx = Collections.binarySearch(ans, nums[i]);
                if(idx < 0){
                    idx = -(idx+1);
                }
                ans.set(idx, nums[i]);
            }
        }
        return ans.size();
    }
    public static void main(String[] args) {
        int[]  nums = {10, 9, 2, 5, 3, 7, 101, 18};  
        System.out.println(lis(nums));
    }
    
}
