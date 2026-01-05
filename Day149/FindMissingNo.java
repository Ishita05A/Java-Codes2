package Day149;

import java.util.Scanner;

public class FindMissingNo {
    static int missingNo(int[] arr){
        int sum=0;
        for(int i = 1;i<=arr.length+1;i++){
            sum+=i;
        }
        for(int i = 0;i<arr.length;i++){
            sum-=arr[i];
        }
        return sum;
    }
    static int missingNo_optimized(int[] arr){
        int xor1=0,xor2=0;
        for(int i = 0;i<arr.length;i++){
            xor1^=arr[i];
        }
        for(int i = 0;i<=arr.length+1;i++){
            xor2^=i;
        }
        return xor2^xor1;
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
        System.out.println(missingNo(arr));
        System.out.println(missingNo_optimized(arr));
        sc.close();
    }
    
}
