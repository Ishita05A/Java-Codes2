package Day143;

import java.util.Scanner;

public class CountNoOfNiceSubArray {
    static int count(int[] arr,int k){
        int l = 0,sum = 0,cnt = 0;
        for(int r = 0;r<arr.length;r++){
            sum+=arr[r]%2;
            while(sum>k){
                sum-=arr[l]%2;
                l++;
            }
            cnt+=(r-l+1);
        }
        return cnt;
    }
    static int findNiceSubArray(int[] arr,int k){
        return count(arr, k)-count(arr, k-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findNiceSubArray(arr, 3));
        sc.close();
    }
    
}
