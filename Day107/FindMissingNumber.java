package Day107;

import java.util.Scanner;
import java.util.HashSet;

public class FindMissingNumber {
    static int find_missing(int[] arr){
        int n = arr.length;
        int expected_sum = n*(n+1)/2;
        for(int num:arr) expected_sum -= num;
        return expected_sum;

    }
    static int findMissing(int[] arr){
        int n = arr.length;
        HashSet<Integer> mp = new HashSet<>();
        for(int num : arr) mp.add(num);
        for(int i = 0;i<n;i++){
            if(!mp.contains(i)) return i;
        }
        return n;

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
        System.out.println(find_missing(arr));
        sc.close();
    }
    
}
