package Day163;

import java.util.Scanner;

public class RoatedSorted {
    static boolean isSorted(int[] arr){
        int count = 0;
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]) count++;
        }
        if(arr[0] > arr[arr.length-1]) count++;
        if(count == 0 || count == 2) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements for value");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(isSorted(arr));
        sc.close();
    }
    
}
