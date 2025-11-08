package Day109;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;


public class CosequtiveSubSequence {
    static int count(int[] arr){
        int c=1;
        int max = 1;
        Arrays.sort(arr);
        for(int i =1;i<arr.length;i++){
            if(arr[i-1]+1 ==arr[i]) {
                c++;
                max = Math.max(max, c);
            }
            else c =1;
        }
        return max;
    }
    static int count1(int[] arr){
        
        int max = 0;
        int x =0;

        HashSet<Integer> mp = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            mp.add(arr[i]);
        }
        for(int e : mp){
            int c = 0;
            if(!mp.contains(e-1)){
                
                 x=e;
                 while(mp.contains(x)){
                    c++;
                    x++;
                 }

            }
            max = Math.max(max, c);
        }
        return max;
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
        System.out.println(count(arr));
        System.out.println(count1(arr));
        sc.close();
    }
    
}
