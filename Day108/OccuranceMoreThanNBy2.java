package Day108;

import java.util.HashMap;
import java.util.Scanner;

public class OccuranceMoreThanNBy2 {
    static int find_occurance(int[] arr){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int n =arr.length;
        for(int i = 0;i<n;i++)
        {
            if(!mp.containsKey(arr[i])) mp.put(arr[i], 1);
            else mp.put(arr[i], mp.get(arr[i])+1);
        }
        for(var e:mp.entrySet()){
            if(e.getValue() >n/2) return e.getKey();
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
        System.out.println(find_occurance(arr));
        sc.close();
    }
    
}
