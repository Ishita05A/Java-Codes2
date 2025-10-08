package Day95;

import java.util.Scanner;
import java.util.Stack;

public class SumOfSubArrMIN {
    static int[] psee(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]) st.pop();
            pse[i] = st.isEmpty() ? i+1 : i-st.peek(); 
            st.push(i);
        }
        return pse;
    }

    static int[] nsee(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            nse[i] = st.isEmpty() ? n-i: st.peek()-i;
            st.push(i);
        }
        return nse;
    }

    static int sum_of_min_subArray(int[] arr){
        int total = 0;
        int mod = (int)1e7 +9;
        int[] nse = nsee(arr);
        int[] pse = psee(arr);
        for(int i = 0;i<arr.length;i++){
            total = (total + arr[i]*pse[i]*nse[i])%mod;
        }
        return total;
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
        System.out.println(sum_of_min_subArray(arr));
        sc.close();
    }
    
}
