package Day123;

import java.util.Scanner;

public class BookAllocation {
   static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++) max = Math.max(max, arr[i]);
        return max;
    }
    static int find_sum(int[] arr){
        int sum = 0;
        for(int num : arr) sum+=num;
        return sum;
    }
    static int findStudents(int[] arr,int pages){
        int student = 1;
        int currentPages = 0;
        for(int num:arr){
            if(num+currentPages<=pages){
                currentPages+=num;
            }
            else {
                currentPages = num;
                student++;
            }
        }
        return student;
    }
    static int find_maximum_pages(int[] arr,int student){
        int st = findMax(arr);
        int end = find_sum(arr);
        for(int i = st;i<=end;i++){
            int find_student = findStudents(arr,i);
            if(find_student == student) return i;
        }
        return -1;
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
        System.out.println("Enter target");
        int target = sc.nextInt();
        System.out.println(find_maximum_pages(arr, target));
        sc.close();
    }
    
}
