package Day120;

import java.util.Scanner;

public class Findpeak{
   static int find_peak_element(int[] arr){
        int n = arr.length;
        if(n==1) return arr[0];
        if(arr[0] > arr[1]) return arr[0];
        if(arr[n-1] > arr[n-2]) return arr[n-1];
        int st = 1;
        int end = n-2;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) return arr[mid];
            else if(arr[mid] < arr[mid+1]) st = mid+1;
            else end = mid -1; 
        }
        return -1;
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
        System.out.println(find_peak_element(arr));
        sc.close();
    }
}