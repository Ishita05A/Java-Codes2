package Day203;

public class MaximumSumOfNonAdjecent {
    static int findMaxSum(int[] arr,int idx){
        if(idx == 0) return arr[idx];
        if(idx<0) return 0;
        int pick = arr[idx]+findMaxSum(arr, idx-2);
        int notPick = 0+ findMaxSum(arr, idx-1);
        return Math.max(pick, notPick);
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        System.out.println(findMaxSum(arr, 3));
    }
    
}
