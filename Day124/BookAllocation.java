package Day124;

import java.util.Scanner;

public class BookAllocation {
    static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i]);
        return max;
    }
    static int find_sum(int[] arr){
        int sum = 0;
        for(int num : arr) sum+=num;
        return sum;
    }
    static int allocate_student(int[] arr, int max_page){
        int student = 1;
        int current_pages = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]+current_pages <= max_page){
                current_pages+=arr[i];
            }
            else{
                current_pages = arr[i];
                student++;
            }
        }
        return student;
    }
    static int min_pages_book_allocation(int[] arr,int student){
        int st = findMax(arr);
        int end = find_sum(arr);
        int ans = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            int find_student = allocate_student(arr,mid );
            if(find_student>student){
                
               st = mid+1;
            }
          
            else {
                ans = mid;
                end = mid-1;
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
        System.out.println("Enter no of students");
        int k = sc.nextInt();
        System.out.println(min_pages_book_allocation(arr, k));
        sc.close();
    }
    
}
