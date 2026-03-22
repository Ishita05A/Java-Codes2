package Day200.Recursion;

public class CheckIfSumExist {
    static boolean helper(int[] arr,int idx,int sum){
        if(sum == 0) return true;
        if(idx == arr.length || sum < 0) return false;
        return helper(arr,idx+1,sum) || helper(arr, idx+1, sum-arr[idx]);
    }
    static boolean isSubSequenceSum(int[] arr,int k){
        return helper(arr, 0, k);
    }
    public static void main(String[] args) {
        // int[] arr ={1, 2, 3, 4, 5};
        int[] arr =  {4, 3, 9, 2};
        System.out.println(isSubSequenceSum(arr, 10));
    }
    
}
