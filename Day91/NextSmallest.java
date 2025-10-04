package Day91;

import java.util.Scanner;
import java.util.Stack;

// Input: arr = [4, 8, 5, 2, 25]
// Output: [2, 5, 2, -1, -1]

public class NextSmallest {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    static int[] nextSmallest(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()>arr[i]) st.pop();
            if(st.isEmpty()) nse[i] = -1;
            else nse[i] = st.peek();
            st.push(arr[i]);
        }
        return nse;
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
        int[] ans = nextSmallest(arr);
        display(ans);
        sc.close();
    }
    
}
