package Day195;

import java.util.*;
public class PairSumExist {
    static boolean pairSum(int[] arr,int target){
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if( sum == target) {
                return true;
            }
            else if(sum<target) left++;
            else right--;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        System.out.println(pairSum(arr, 14));
    }
    
}
