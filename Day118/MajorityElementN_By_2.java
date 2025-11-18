package Day118;

import java.util.Scanner;

public class MajorityElementN_By_2 {
    static int findMajority(int[] arr){
        int n = 0;
        int count = 0;
        int ele = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(ele == arr[i]) count++;
            else{
                ele = arr[i];
                count = 0;
            }
        }
        count = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == ele) count++;
        }
        if(count > n/2) return ele;
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
        System.out.println(findMajority(arr));
        sc.close();
    }
    
}
