package Day163;

import java.util.Scanner;

public class QuickSort {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr,int st,int end){
        int pi = arr[st];
        int count = 0;
        for(int i = st+1;i<=end;i++){
            if(arr[i] <= pi) count++;
        }
        int pivot_idx = count+st;
        swap(arr, st, count+st);
        pi = arr[pivot_idx];
        int i = st;
        int j = end;
        while(i<pivot_idx && j>pivot_idx){
            if(arr[i] > pi && arr[j]<pi){
                swap(arr, i, j);
                i++;
                j--;
            }
            else if(arr[i]<pi) i++;
            else j--;
        }
        return pivot_idx;

    }
    static void quickSort(int[] arr,int st,int end){
        if(st>=end) return;
        int pi = partition(arr,st,end);

        quickSort(arr, st, pi-1);
        quickSort(arr, pi+1, end);
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
        quickSort(arr, 0, n-1);
        display(arr);
        sc.close();
        
    }
}
