package Day105;

import java.util.HashMap;
import java.util.Scanner;

public class CountFrequency {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int ans1 = 0;
        int ans2 = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            if(!mp.containsKey(arr[i])) mp.put(arr[i], 1);
            else mp.put(arr[i], mp.get(arr[i])+1);
        }
        System.out.println(mp);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for( var e : mp.entrySet() ){
            if(e.getValue() > max){
                max = e.getValue();
                 ans1 = e.getKey();
            } 
            if(e.getValue() < min){
                 min = e.getValue();
                  ans2 = e.getKey();
            }
        }
        System.out.printf("max freq = %d and min freq = %d",ans1,ans2);
        sc.close();
    }
    
}
