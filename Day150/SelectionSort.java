package Day150;

import java.util.Scanner;

public class SelectionSort {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void selectionSort(int[] arr){
        for(int i = 0;i<arr.length;i++){
            int min_idx = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j] < arr[min_idx]) min_idx = j;
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
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
        selectionSort(arr);
        display(arr);
        sc.close();
    }
    
}
