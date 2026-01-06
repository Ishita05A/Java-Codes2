package Day150;

import java.util.Scanner;

public class MergeSort {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void merge(int[] arr,int st,int mid,int end){
        int[] left = new int[mid-st+1];
        int[] right = new int[end-mid];
        for(int i = 0;i<left.length;i++){
            left[i] = arr[st+i];
        }
        for(int i = 0;i<right.length;i++){
            right[i] = arr[mid+i+1];
        }
        int i = 0,j=0,k=st;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                arr[k++] = left[i++];
            }
            else arr[k++] = right[j++];
        }
        while(i<left.length){
            arr[k++] = left[i++];
        }
        while(j<right.length){
            arr[k++] = right[j++];
        }
    }
    static void merge_sort(int[]arr,int st,int end){
        if(st>=end) return;
        int mid = (st+end)/2;
        merge_sort(arr, st, mid);
        merge_sort(arr, mid+1, end);
        merge(arr, st, mid, end);
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
        merge_sort(arr, 0, n-1);
        display(arr);
        sc.close();
    }
    
}
