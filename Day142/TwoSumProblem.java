package Day142;


import java.util.Arrays;
import java.util.Scanner;

public class TwoSumProblem {
    static void findSumIdx(int[] arr,int target){
        Arrays.sort(arr);
        int n = arr.length;
        int i = 0;
        int j = n-1;
        while(i<j){
            if(arr[i] + arr[j] == target) {
                System.out.println("yes");
                return;
            }
            else if(arr[i] + arr[j] >target) j--;
            else i++;
        }
        System.out.println("no");;
    }
    static void display(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
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
        findSumIdx(arr,14 );
    
        sc.close();

    }
    
    
}
