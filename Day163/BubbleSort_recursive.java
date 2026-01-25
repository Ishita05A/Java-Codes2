package Day163;

import java.util.Scanner;

public class BubbleSort_recursive {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void bubble_sort_recursive(int[] arr,int n){
        if(n == 1) return;
        boolean didSwap = false;
        for(int j = 0;j<n-1;j++){
            if(arr[j]>arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                didSwap = true;
            }
        }
        if(!didSwap) return;
        bubble_sort_recursive(arr, n-1);
    }
    static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n-i-1;j++){
                if(arr[j] >arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
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
        // bubbleSort(arr);
        bubble_sort_recursive(arr, n);
        display(arr);
        sc.close();
    }
    
}
