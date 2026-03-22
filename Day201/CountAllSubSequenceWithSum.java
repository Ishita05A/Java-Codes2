package Day201;

public class CountAllSubSequenceWithSum {
    static int helper(int[] arr, int idx, int sum) {
        if (idx == arr.length) {
            if (sum == 0) {
                return 1;
            }
            return 0;
        }
        if (sum < 0) return 0;
        return helper(arr, idx+1, sum) + helper(arr, idx+1, sum-arr[idx]);
        
    }
    static int countSubSequence(int[] arr,int k){
        return helper(arr, 0, k);
    }
    public static void main(String[] args) {
        int[]  nums = {4, 9, 2, 5, 1};
        System.out.println(countSubSequence(nums, 10));
    }

}
