package Day142;

import java.util.Scanner;

public class findMissingNo {
    static int findMissing(int[] arr){
        int n = arr.length;
        int sum = 0;
        for(int i = 1;i<=n+1;i++){
            sum+=i;
        }
        for(int i = 0;i<n;i++){
            sum-=arr[i];
        }
        return sum;
    }
    static int findMissing_optimized(int[] arr){
        int n = arr.length;
        int xor1 = 0;
        int xor2 = 0;
        for(int i = 1;i<=n+1;i++){
            xor1^=i;
        }
        for(int i = 0;i<n;i++){
            xor2^=arr[i];
        }
        return xor1^=xor2;
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
        System.out.println(findMissing(arr));
        System.out.println(findMissing_optimized(arr));
        sc.close();
    }
    
}
