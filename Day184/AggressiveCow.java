package Day184;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCow {
    static int min(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int num : arr){
            min = Math.min(num, min);
        }
        return min;
    }

    static int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num : arr){
            max = Math.max(num, max);
        }
        return max;
    }
    static boolean isPossible(int[] arr,int minDist,int k){
        int noOfCows = 1;
        int last = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(arr[i]-last >= minDist){
                noOfCows++;
                last = arr[i];
            }
        }
        if(noOfCows>=k) return true;
        return false;
    }
    static int findMax_minDistance(int[] arr,int k){
        Arrays.sort(arr);
        int st = 0;
        int ans = 0;
        int end = max(arr)-min(arr);
        while(st<=end){
            int mid = (end - st)/2+st;
            if(isPossible(arr,mid,k) == true){
                ans = mid;
                st = mid+1;
            }
            else end = mid-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(findMax_minDistance(arr, 4));
        sc.close();
    }
    
}
