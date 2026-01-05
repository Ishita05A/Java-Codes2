package Day149;

import java.util.Scanner;

public class MajorityElementByNby2 {
    static int findMajorityElement(int[] arr){
        int count = 0;
        int ele = 0;
        int n = arr.length;
        for(int i = 0;i<arr.length;i++){
            if(ele == 0) ele = arr[i];
            if(arr[i] == ele) count++;
            else count--;
        }
        count = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == ele) count++;
        }
        if(count>n/2) return ele;
        return -1;
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
        System.out.println(findMajorityElement(arr));
        sc.close();
    }
    
}
