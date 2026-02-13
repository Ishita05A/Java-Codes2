package Day172;
import java.util.Scanner;

public class BookAllocation {
    static int findMax(int[] arr){
        int max = 0;
        for(int num:arr) max = Math.max(max,num);
        return max;
    }
    static int findSum(int[] arr){
        int sum = 0;
        for(int num:arr) sum+=num;
        return sum;
    }
    static int booksAllocated(int[] arr,int maxPages){
        int books = 1;
        int pages = 0;
        for(int i = 0;i<arr.length;i++){
            if(pages+arr[i] > maxPages){
                books++;
                pages = 0;
            }
            pages += arr[i];
        }
        return books;
    }
    static int minPages(int[] arr,int m){
        int st = findMax(arr);
        int end = findSum(arr);
        int ans = -1;
        while(st<=end){
            int mid = (st+end)/2;
            int booksAllocated = booksAllocated(arr, mid);
                if(booksAllocated <= m){
                    ans = mid;
                    end = mid-1;
                }
                else st = mid + 1;
            
        }
        return ans;
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
        System.out.println(minPages(arr, 4));
        sc.close();
    }
    
}
