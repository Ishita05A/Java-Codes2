package Day106;

import java.util.Scanner;

public class SecondLargest {
    static void max_secondMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int sec_max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>max) max = arr[i];
            if(arr[i]> sec_max && max != arr[i]) sec_max = arr[i]; 
        }
        System.out.printf("max %d second max %d",max,sec_max);
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
        max_secondMax(arr);
        sc.close();
    }
    
}
