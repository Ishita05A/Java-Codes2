package Day108;

import java.util.Scanner;

public class KAprintSubArray {
    static void subArray(int[] arr){
        int st = 0;
        int sum=0;
        int max = Integer.MIN_VALUE;
        int last = 0;
        int first = 0;
        for(int end = 0;end<arr.length;end++){
             sum+=arr[end];
             if(sum > max){
                max = sum;
                first = st;
                last = end;
             }
             if(sum < 0){
                sum = 0;
                st = end+1;
             } 
        }
        for(int i = first;i<=last;i++ ){
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
        subArray(arr);
        sc.close();
    }
    
}
