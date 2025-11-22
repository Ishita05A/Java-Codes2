package Day122;

import java.util.Scanner;

public class NoOfBouquet {
    static int findMinimum(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length;i++){
            min = Math.min(min, arr[i]);
        }
        return min;
    }
    static int findMaximum(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            max = Math.max(max, arr[i]);
        }
        return max; 
    }
    static int minBouquet(int[] arr,int day,int n){
        int count = 0;
        int no_of_bouquet = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] <= day) count++;
            else{
                no_of_bouquet+=(count/n);
                count = 0;
            }
            
        }
        no_of_bouquet+=(count/n);
        return no_of_bouquet;
    }
    static int find_minimum_bouquet(int[] arr,int m,int n ){
        int st = findMinimum(arr);
        int end = findMaximum(arr);
        int count = 0;
        int no_of_bouquet = end;
        int ans = -1;
        for(int i = st;i<=end;i++){
            count = minBouquet(arr, i, n);
            if(count >= m){
                if(count < no_of_bouquet){
                    no_of_bouquet = count;
                    ans = i;
                }
            }
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
        System.out.println(find_minimum_bouquet(arr, m, k));
        sc.close();
        

    }
}
