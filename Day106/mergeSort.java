package Day106;

import java.util.Scanner;

public class mergeSort {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static int[] merge_sort(int[] arr,int st,int end,int mid){
        int[] left = new int[mid-st+1];
        int[] right = new int[end-mid];
        for(int i = 0;i<left.length;i++){
            left[i] = arr[i+st];
        }
        for(int i = 0;i<right.length;i++){
            right[i] = arr[i+mid+1];
        }
        int i = 0;
        int j = 0;
        int k = st;
        while(i !=left.length && j != right.length){
            if(left[i] <= right[j]){
                arr[k++] = left[i];
                i++;
            }
            if(right[j] < left[i]){
                arr[k++] = right[j];
                j++;
            }
        }
        while (i<left.length) {
            arr[k++] = left[i];
            i++;
        }
        while(j<right.length){
            arr[k++] = right[j];
            j++; 
        }
        return arr;
    }
    static void merge(int[] arr,int st,int end){
        if(st>=end) return;
        int mid = (st+end)/2;
        merge(arr, st, mid);
        merge(arr, mid+1, end);
        merge_sort(arr, st, end, mid);



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
        merge(arr, 0, n-1);
        display(arr);
        sc.close();
    }
    
}
