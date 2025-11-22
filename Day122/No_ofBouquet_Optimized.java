package Day122;

import java.util.Scanner;

public class No_ofBouquet_Optimized {
    static int findMinimum(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length;i++) min = Math.min(min, arr[i]);
        return min;
    }
    static int findMaximum(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++) max = Math.max(max, arr[i]);
        return max;
    }
    static int findDays(int[] arr,int day,int n){
        int no_of_bouquet = 0;
        int count = 0;
        for(int i  = 0;i<arr.length;i++){
           if(arr[i]<=day) count++;
           else{
            no_of_bouquet+=(count/n);
            count = 0;
           }
        }
        no_of_bouquet+=(count/n);
        return no_of_bouquet;
    }
    static int minimumBouquet(int[] arr,int m,int k){
        int st = findMinimum(arr);
        int end = findMaximum(arr);
        int no_of_bouquet = end;
        int ans = -1;
        for(int i = st;i<=end;i++){
            int mid = (end-st)/2+st;
            int count = findDays(arr, mid, k);
            if(count >= m){
                if(count <= no_of_bouquet){
                    no_of_bouquet = count;
                    ans = mid;
                }
                end = mid - 1;
            }
            else st = mid +1;
        }
        return ans;
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
         System.out.println("Enter day to blosoom flower");
        int m = sc.nextInt();
        System.out.println("Enter no. of bouquet required");
        int k = sc.nextInt();
        System.out.println(minimumBouquet(arr, m, k));
        sc.close();
    }
    
}
