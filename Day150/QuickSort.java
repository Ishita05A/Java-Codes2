package Day150;

import java.util.Scanner;

public class QuickSort {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp =arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr,int st,int end){
        int pivot = arr[st];
        int count = 0;
        for(int i = st+1;i<=end;i++){
            if(arr[i] <pivot) count++;
        }
        int pivot_idx = st+count;
        swap(arr, st, st+count);
        pivot = arr[pivot_idx];
        int i = st,j = end;
        while(i<pivot_idx && j>pivot_idx){
            while(arr[i]<pivot) i++;
            while(arr[j]<pivot) j--;
            if(i<pivot_idx && j>pivot_idx) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return pivot_idx;
    }
    static void quickSort(int[] arr,int st,int end){
        if(st>= end) return;
        int pi = partition(arr, st, end);
        quickSort(arr, st, pi-1);
        quickSort(arr, pi+1, end);
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
        quickSort(arr, 0, n-1);
        display(arr);
        sc.close();
        
    }
    
}
