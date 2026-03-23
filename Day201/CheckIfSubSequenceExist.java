package Day201;

public class CheckIfSubSequenceExist {
    static boolean helper(int[] arr,int idx,int sum){
        if(sum<0) return false;
        if(idx == arr.length){
            if(sum == 0) return true;
            return false;
        }
        return helper(arr, idx+1, sum) || helper(arr, idx+1, sum-arr[idx]);

    }
    static boolean isSubSequenceSum(int[] arr,int k){
        return helper(arr, 0, k);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(isSubSequenceSum(arr, 8));
    }
    
}
