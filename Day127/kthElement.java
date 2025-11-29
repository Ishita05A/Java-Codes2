package Day127;

import java.util.Scanner;

public class kthElement {
    
    static int find_kth_element(int[] arr1,int[] arr2,int k){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int cnt = 1;
        int i = 0 , j = 0;
        while(i<n1 && j<n2){
            if(arr1[i]<=arr2[j]){
                if(cnt == k) return arr1[i];
                cnt++;
                i++;
            }
            else{
                if(cnt == k) return arr2[j];
                cnt++;
                j++;
            }
        }
        while (i<n1) {
            if(cnt == k) return arr1[i];
                cnt++;
                i++;
        }
        while (j<n2) {
            if(cnt == k) return arr2[j];
                cnt++;
                j++;
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
        System.out.println("Enter no. of elements");
        int m = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr1 = new int[m];
        for (int j = 0; j < m; j++) {
            arr1[j] = sc.nextInt();
        }
        System.out.println("enter kth value");
        int k = sc.nextInt();
        System.out.println(find_kth_element(arr,arr1 , k));
        sc.close();
    }
    
}
