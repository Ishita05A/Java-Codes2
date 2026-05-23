package Day222;

public class isSumExist {
    static boolean helper(int[] arr, int k,int idx){
        if(idx == arr.length || k<0) return false;
        if(k == 0){
            return true;
        }
        return helper(arr, k, idx+1) || helper(arr, k-arr[idx], idx+1);
    }
    static boolean isSum(int[] arr , int k){
        return helper(arr, k, 0);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(isSum(arr, 8));
    }
    
}
