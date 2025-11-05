package Day106;

import java.util.Scanner;

public class sorting {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i =0;i<n;i++){
            int min_idx = i;
            for(int j = i+1;j<n;j++){
                if(arr[j]<arr[min_idx]) min_idx = j;
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
    static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i = 1;i<n;i++){
            for(int j = i;j>0;j--){
                if(arr[j-1]>arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
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
        insertionSort(arr);
        display(arr);
        sc.close();
        
    }
    
}
