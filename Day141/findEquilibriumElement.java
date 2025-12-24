package Day141;

import java.util.Scanner;

public class findEquilibriumElement {
    static int totalSum(int[] arr){
        int total = 0;
        for(int i = 0;i<arr.length;i++){
            total+=arr[i];
        }
        return total;
    }
    static int findEquilibrium(int[] arr){
        int prefix = 0;
        int suffix = totalSum(arr);
        for(int i = 0;i<arr.length;i++){
            suffix -= arr[i]; 
            if(prefix == suffix) return i;
            prefix += arr[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(findEquilibrium(arr));
        sc.close();
    }
    
}
