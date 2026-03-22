package Day200.Recursion;

public class CountAllSubSequence {
    static int helper(int[] arr,int idx,int sum){
        if(sum == 0) return 1;
        if(idx == arr.length || sum<0) return 0;
        return helper(arr, idx+1, sum)+ helper(arr, idx+1, sum-arr[idx]);
    }
    static int countSubSequence(int[] arr,int k){
        return helper(arr, 0, k);
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 10, 5, 1, 3};
        System.out.println(countSubSequence(arr, 5));
    }
    
}
