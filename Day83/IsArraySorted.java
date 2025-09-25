package Day83;

import java.util.Scanner;

public class IsArraySorted {
    static boolean isSorted(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
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
        System.out.println(isSorted(arr));
        sc.close();
    }
    
}
