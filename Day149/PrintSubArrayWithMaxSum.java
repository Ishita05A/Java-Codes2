package Day149;

import java.util.Scanner;

public class PrintSubArrayWithMaxSum {
    static void printSubArray(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int st = 0;
        int ansEnd = 0;
        int sum = 0;
        int ansSt = 0;
        for(int i = 0;i<arr.length;i++){
            if(sum<0) {
                sum = 0;
                st = i;
            }
            sum+=arr[i];
            if(sum>maxSum){
                maxSum = sum;
                ansEnd = i;
                ansSt = st;
            }
        }
        for(int i = ansSt;i<=ansEnd;i++){
            System.out.print(arr[i]+" ");
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printSubArray(arr);
        sc.close();
    }
    
}
