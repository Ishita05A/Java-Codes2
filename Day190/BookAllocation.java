package Day190;

import java.util.Scanner;

public class BookAllocation {
    static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    static int findTotal(int[] arr){
        int total = 0;
        for(int num:arr) total+=num;
        return total;
    }
    static int countStudent(int[] arr,int minPages){
        int countStudent = 1;
        int totalPages = 0;
        for(int i = 0;i<arr.length;i++){
            totalPages += arr[i];
            if(totalPages > minPages){
                countStudent++;
                totalPages = arr[i];
            }
        }
        return countStudent;
    }
    static int findMinpages(int[] arr,int k){
        int st = findMax(arr);
        int end = findTotal(arr);
        int ans = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            int students = countStudent(arr, mid);
            if(students <= k){
                ans = mid;
                end = mid-1;
            }
            else{
                
                st = mid + 1;
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
        System.out.println(findMinpages(arr, 2));
        sc.close();
    }
    
}
