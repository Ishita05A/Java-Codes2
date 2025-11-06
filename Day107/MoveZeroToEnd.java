package Day107;

import java.util.Scanner;

public class MoveZeroToEnd {
     static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void swap(int[] arr,int i,int j){
        
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
        
    }
    static void zeroAtEnd(int[] arr){
        int i = 0;
        int j= arr.length-1;
        while(i<j){
            if(arr[i] == 1 && arr[j] == 0 ){
                 swap(arr, i, j);
                 i++;
                 j--;
            }
            if(arr[i] == 0) i++;
            if(arr[j]== 1) j--;
            
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
        zeroAtEnd(arr);
        display(arr);
        sc.close();
    }
    
}
