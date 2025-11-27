package Day126;

import java.util.Scanner;

public class MedianOf2SortedArray {
    static double mergeArray(int[] arr,int[] arr1){
        int n = arr.length;
        int m = arr1.length;
        int[] num = new int[n+m];
        int i  = 0 , j =0;
        int k =0;
        while(i<n && j< m){
            if(arr[i]<=arr1[j]) num[k++] = arr[i++];
            else num[k++] = arr1[j++];
        }
        while(i<n) num[k++] = arr[i++];
        while(j<m) num[k++] = arr1[j++];
        if((n+m)%2!=0) return num[(n+m)/2];
        int idx = (n+m)/2;
        double sum = (((double)num[idx]+num[idx-1]))/2;
        return sum;

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
        System.out.println("Enter no. of elements");
        int m = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr1 = new int[n];
        for (int j = 0; j < m; j++) {
            arr1[j] = sc.nextInt();
        }
        System.out.println(mergeArray(arr, arr1));
        sc.close();
    }
}
