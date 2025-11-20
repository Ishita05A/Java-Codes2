package Day120;

import java.util.Scanner;

public class Floor_Ceil {
    static int[] findFloor_ceil(int[] arr,int target){
        int st = 0;
        int end = arr.length-1;
        int ceil = arr[arr.length-1];
        int floor = arr[0];
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid] == target) return new int[] {arr[mid], arr[mid]};
            else if(arr[mid] > target){
                ceil = arr[mid];
                end = mid-1;
            }
            else {
                floor = arr[mid];
                st = mid+1;
            }
        }
        return new int[] {floor,ceil};
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
        int[] ans = findFloor_ceil(arr, target);
        System.out.printf("Floor %d  Ceil %d",ans[0],ans[1]);
        sc.close();
    }
    
}
