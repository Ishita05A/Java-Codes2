package Day118;

import java.util.Scanner;

public class PrintSubArray {
    static void print_subArray(int[] arr){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int ansStart = 0;

        for(int i =0;i<arr.length;i++){
            if(sum == 0) start = i;
            sum+=arr[i];
            
            if(sum>max){
                max = sum;
                end = i;
                ansStart = start;
            }
            if(sum<0){
                sum = 0;
            }

        }
        for(int i = ansStart;i<=end;i++){
            System.out.print(arr[i]+" ");
        }
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
        print_subArray(arr);
        sc.close();
    }
    
}
