package Day118;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class TwoSum {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static int[] find2Sum(int[] arr,int target){
        Arrays.sort(arr);
        int i = 0;
        int n = arr.length;
        int j = n-1;
        while(i<j){
            int sum = arr[i] + arr[j];
            if(sum == target) return new int[] {arr[i],arr[j]};
            else if(sum>target) j--;
            else i++;
        }
        return new int[] {-1,-1};
    }
    static int[] find_2_sum(int[] arr,int target){
        HashSet<Integer> mp = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            if(mp.contains(target-arr[i])) return new int[] {target-arr[i],arr[i]};
            mp.add(arr[i]);
        }
        return new int[] {-1,-1};
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
        int[] ans = find_2_sum(arr, 4);
        display(ans);
        ans = find2Sum(arr, 4);
        display(ans);
        sc.close();
    }
    
}
