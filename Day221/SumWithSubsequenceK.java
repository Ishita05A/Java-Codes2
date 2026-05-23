package Day221;

public class SumWithSubsequenceK {
    static int helper(int[] arr,int target,int idx){
        if(target == 0){
            return 1;
        }
        if(target < 0 || idx == arr.length) return 0;
        return helper(arr, target, idx+1) + helper(arr, target-arr[idx], idx+1);
    }
    static int countSubSeq(int[] arr, int k){
        return helper(arr, k, 0);
    }
    public static void main(String[] args) {
        int[] arr = {4,9,2,5,1};
        System.out.println(countSubSeq(arr, 10));
    }
    
}
