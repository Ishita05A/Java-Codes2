package Day111;

import java.util.Scanner;

public class MajorityN_by2 {
    static int majority(int[] arr){
        int ele= arr[0];
        int count =1;
        for(int i =1;i<arr.length;i++){
            if(arr[i] == ele) count++;
            else count--;
            if(count == 0) {
                ele = arr[i];
                count = 1;
            }
        }
        count = 0;
        for(int i= 0;i<arr.length;i++){
            if(arr[i] == ele) count++;
        }
        if(count >arr.length/2) return ele;
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
        System.out.println(majority(arr));
        sc.close();
    }
    
}
