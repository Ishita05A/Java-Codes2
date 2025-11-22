package Day121;

import java.util.Scanner;

public class KokoEatingBanana {
    static int findMax(int[] arr){
            int max = Integer.MIN_VALUE;
            for(int i = 0;i<arr.length;i++){
                max = Math.max(max, arr[i]);
            }
            return max;
        }
        static long findHour(int[] arr,int hourly){
            long totalHour = 0;
            for(int i = 0;i<arr.length;i++){
                totalHour+=(int)Math.ceil((double)arr[i]/hourly);
            }
            return totalHour;
        }

        static int findMinimumTime(int[] arr, int h){
            int st = 1;
            int end = findMax(arr);
            int ans = -1;
            while(st<=end){
                int mid = (end-st)/2+st;
                long totalHour = findHour(arr, mid);
                if(totalHour <= h){
                    ans = mid;
                    end = mid-1;
                }
                else st = mid+1;
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
        System.out.println("Enter target Hour");
        int target = sc.nextInt();
        System.out.println(findMinimumTime(arr, target));
        sc.close();

    }
    
}
