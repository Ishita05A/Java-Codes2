package Day162;

import java.util.HashMap;
import java.util.Scanner;

public class ContainsDuplicate {
    static boolean isContainDuplicate(int[] arr){
        HashMap<Integer,Integer> mp =new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i], 0)+1);
        }
        for(var e: mp.entrySet()){
            if(e.getValue() >1) return true;
        }
        return false;
        
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
        System.out.println(isContainDuplicate(arr));
        sc.close();
    }

}
