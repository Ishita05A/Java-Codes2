package Day146;

import java.util.Scanner;

public class NumberOfNiceSubArray {
    static int count_niceSubArray_brute(int[] arr,int k){
        int count_subArray=0;
        for(int i =0;i<arr.length;i++){
            int count_odd = 0;
            for(int j = i;j<arr.length;j++){
                if(arr[j]%2 == 1) count_odd++;
                if(count_odd>k) break;
                if(count_odd == k) count_subArray++;
            }
        }
        return count_subArray;
    }
    static int count_lessAndEqual(int[] arr,int k){
        int l = 0;
        int count = 0;
        int count_odd = 0;
        for(int r = 0;r<arr.length;r++){
             if(arr[r] % 2 == 1) count_odd++;
             while(count_odd > k){
                if(arr[l]%2 == 1) count_odd--;
                l++;
             }
             if(count_odd <= k) count+=(r-l+1);
        }
        return count;
    }
    static int count_niceSubArray_optimized(int[] arr,int k){
        return count_lessAndEqual(arr, k)-count_lessAndEqual(arr, k-1);
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
        System.out.println(count_niceSubArray_brute(arr, 3));
        System.out.println(count_niceSubArray_optimized(arr, 3));
        sc.close();
    }
    
}
