package Day163;

import java.util.Scanner;

public class InsertionSort_recursive {
     static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void insertion_Sort_recursive(int[] arr,int n){
        if(n == arr.length) return;
        for(int j = n;j>0;j--){
            if(arr[j]<arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
        insertion_Sort_recursive(arr, n+1);
    }
    static void insertion_Sort(int[] arr){
        int n = arr.length;
        for(int i = 0;i<n;i++){
            for(int j = i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
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
        // insertion_Sort(arr);
        insertion_Sort_recursive(arr, 1);
        display(arr);
        sc.close();
        
    }
    
}
