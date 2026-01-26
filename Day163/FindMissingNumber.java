package Day163;

import java.util.Scanner;

public class FindMissingNumber {
    static int findMissing(int[] arr){
        int n = arr.length;
        int target = (n+1)*(n+2)/2;
        for(int i = 0;i<arr.length;i++){
            target-=arr[i];
        }
        return target;
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
        System.out.println(findMissing(arr));
        sc.close();
    }
    
}
