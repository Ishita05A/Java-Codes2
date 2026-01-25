package Day162;

import java.util.HashMap;
import java.util.Scanner;
public class HeightAndLowestFrequency {
    static void freq_Of_Array(int[] arr){
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0)+1);
        }
        int min = Integer.MAX_VALUE;
        int minimum = 0;
        int max = Integer.MIN_VALUE;
        int maximum = 0;
        for(var e:mp.entrySet()){
            if(e.getValue()<min){
                min = e.getValue();
                minimum = e.getKey();
            }
            if(e.getValue()>max){
                max = e.getValue();
                maximum = e.getKey();
            }
        }
        System.out.println(minimum);
        System.out.println(maximum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements for value");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        freq_Of_Array(arr);
        sc.close();

    }
}
