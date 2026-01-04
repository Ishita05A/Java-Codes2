package Day148;

import java.util.Scanner;

public class ArrayisSortedAndRoated {
    static boolean isSortedAndRoated(int[] arr){
        int n = arr.length;
        int count = 0;
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]) count++;
        }
        if(arr[0]<arr[n-1]) count++;
        return count<=1;
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
        System.out.println(isSortedAndRoated(arr));
        sc.close();
    }
    
}
