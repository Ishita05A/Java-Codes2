package Day245;
import java.util.*;

public class PrintLongestIncreasing {
    static void helper(int[] nums,int idx,int prev_idx,int[][] dp,List<Integer> curr,List<Integer> best){
        if(idx == nums.length){
            if(curr.size()>best.size()){
                best.clear();
                best.addAll(curr);
            }
            return;
        }
        helper(nums, idx+1, prev_idx, dp, curr, best);
        if(prev_idx == -1 || nums[idx] > nums[prev_idx]){
            curr.add(nums[idx]);
            helper(nums, idx+1, idx, dp, curr, best);
            curr.remove(curr.size()-1);
        }
       
    }
    static List<Integer> printLongest(int[] nums){
        List<Integer> curr = new ArrayList<>();
        List<Integer> best = new ArrayList<>();
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        helper(nums, 0, -1, dp, curr,best);
        return best;
    }
    public static void main(String[] args) {
         int[]  nums = {10, 9, 2, 5, 3, 7, 101, 18};
         System.out.println(printLongest(nums));
    }
}
