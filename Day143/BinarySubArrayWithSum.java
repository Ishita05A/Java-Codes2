package Day143;

import java.util.Scanner;

public class BinarySubArrayWithSum {
    static int count(int[] arr,int goal){
        return countSubArray(arr, goal)-countSubArray(arr, goal-1);
    }
    static int countSubArray(int[] arr,int goal){
        if(goal<0) return 0;
        int count = 0;
        int l = 0,r=0,sum=0;
        while (r<arr.length) {
            sum+=arr[r];
            while(sum>goal){
                sum-=arr[l];
                l++;
            }
            count+=(r-l+1);
            r++;
        }
        return count;
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
        System.out.println(count(arr, 2));
        sc.close();;
    }
    
}
