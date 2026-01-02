package Day146;

import java.util.Scanner;

public class BinarySubArrayWithSum {
    static int binarySubarray_brute(int[] arr,int goal){
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            int sum = 0;
            for(int j = i;j<arr.length;j++){
                sum+=arr[j];
               
                if(sum > goal) break;
                 if(sum == goal) count++;
            }
        }
        return count;
    }
    static int binarySubarray_lessAndEqual(int[] arr,int goal){
        int count = 0;
        int l=0;
        int sum=0;
        for(int r = 0;r<arr.length;r++){
            sum+=arr[r];
            while(sum>goal){
                sum-=arr[l];
                l++;
            }
            if(sum<=goal) count+=(r-l+1);
        }
        return count;
    }

    static int binarySubarray_optimized(int[] arr,int goal){
        return binarySubarray_lessAndEqual(arr, goal)-binarySubarray_lessAndEqual(arr, goal-1);
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
        System.out.println(binarySubarray_brute(arr, 2));
        System.out.println(binarySubarray_optimized(arr, 2));
        sc.close();
    }
    
}
