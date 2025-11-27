package Day126;

import java.util.Scanner;

public class OptimizedGasStation {
    static int numberOfGasStationsRequired(double dist,int[] arr){
        int cnt = 0;
        for(int i = 1;i<arr.length;i++){
            int gap = arr[i]-arr[i-1];
            
            cnt+=(int)Math.ceil(gap/dist)-1;
        }
        return cnt;
    }
    static double findMinimum_distance(int[] arr,int k){
        int n = arr.length;
        double low = 0;
        double high = 0;
        for(int i = 0;i<n-1;i++){
            high = Math.max(high, (double)(arr[i+1]-arr[i]));
        }
        double diff = 1e-6;
        while(high -low >diff){
            double mid = (low+high)/(2.0);
            int cnt = numberOfGasStationsRequired(mid,arr);
            if(cnt>k) low = mid;
            else high = mid;
        }

        return high;
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
        System.out.println("Enter target subarray");
        int target = sc.nextInt();
        System.out.println(findMinimum_distance(arr, target));
        sc.close();
    }
    
}
