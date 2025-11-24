package Day123;

import java.util.Scanner;

public class MinimumDay {

    static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i]);
        return max;
    }
     static int findMinimum(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length;i++) min = Math.min(min, arr[i]);
        return min;
    }
    static int find_adjecent_bouquet(int[] arr, int days, int k) {
        int count = 0;
        int no_of_bouquet = 0;
        for (int num : arr) {

            if (num <= days) {
                count++;
                
            } else{
                no_of_bouquet += (count / k);
                count = 0;
            }
                

        }
        no_of_bouquet += (count / k);
        return no_of_bouquet;
    }

    static int min_day_to_bouquet(int[] arr,int m,int k) {
        int st = findMinimum(arr);
        int end = findMax(arr);
        int ans = -1;
        while (st <= end) {
            int mid = (end - st) / 2 + st;
            int no_of_bouquet = find_adjecent_bouquet(arr, mid, k);
            if(no_of_bouquet>=m){
                ans = mid;
                end = mid -1;

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
        System.out.println("Enter bouquet required");
        int m = sc.nextInt();
        System.out.println("Enter no. of adjecent bloomed roses");
        int k = sc.nextInt();
        System.out.println(min_day_to_bouquet(arr, m, k));
        sc.close();
    }

}
