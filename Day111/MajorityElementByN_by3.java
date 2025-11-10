package Day111;

import java.util.Scanner;
import java.util.*;

public class MajorityElementByN_by3 {
    static ArrayList<Integer> majorityElements(int[] arr){
        HashMap<Integer,Integer> mp = new HashMap<>();
        ArrayList<Integer> a = new ArrayList<>();
        int n = arr.length;
        for(int i = 0;i<arr.length;i++){
            if(!mp.containsKey(arr[i])) mp.put(arr[i],1);
            else mp.put(arr[i], mp.get(arr[i])+1);
        }
        for(var e : mp.entrySet()){
            if(e.getValue()>n/3) a.add(e.getKey());
        }
        return a;
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
        ArrayList<Integer> ans = majorityElements(arr);
        System.out.println(ans);
        sc.close();
    }
    
}
