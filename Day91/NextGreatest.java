package Day91;

import java.util.Scanner;
import java.util.Stack;

public class NextGreatest {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static int[] next_greatest(int[] arr){
        int[] ngl = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i = arr.length-1; i>=0;i--){
            while(!st.isEmpty()  && st.peek()<arr[i]) st.pop();

            
            if(st.isEmpty()) ngl[i] = -1;
            else  ngl[i] = st.peek();
            st.push(arr[i]);
        }
            
        return ngl;
        
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
        int[] ans = next_greatest(arr);
        display(ans);
        sc.close();
    }
    
}
