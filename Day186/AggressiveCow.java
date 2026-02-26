package Day186;

import java.util.Arrays;

public class AggressiveCow {
    static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int it : arr){
            max = Math.max(max, it);
        }
        return max;
    }
    static int findMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int it : arr){
            min = Math.min(min, it);
        }
        return min;
    }

    static int count_cows(int[] arr,int minDist){
        int cow = 1;
        int last_pos = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(arr[i]-last_pos >=minDist){
                cow++;
                last_pos = arr[i];
            }
        }
        return cow;
    }
    
    static int findMinDist(int[] arr,int k){
        Arrays.sort(arr);
        int st = 1;
        int end = findMax(arr) -findMin(arr);
        int ans = -1;
        while(st<=end){
            int mid = (end - st)/2+st;
            int count = count_cows(arr, mid);
            if(count>=k){
                ans = mid;
                st = mid+1;
            }
            else end = mid-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {0,3,4,7,10,9};
        System.out.println(findMinDist(arr,4));
        
    }
}
