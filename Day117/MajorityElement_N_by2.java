package Day117;

import java.util.Scanner;

public class MajorityElement_N_by2 {
    static int majorityElement(int[] arr){
        int ele = arr[0];
        int n = arr.length;
        int count = 1;
        for(int i = 1;i<arr.length;i++){
            if(count == 0) {
                ele = arr[i];
                count = 1;
            }
            else if(ele == arr[i]) count++;
            else count--;
        }
        count = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == ele) count++;
        }
        if(count >n/2) return ele;
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
        System.out.println(majorityElement(arr));
        sc.close();
    }
    
}
