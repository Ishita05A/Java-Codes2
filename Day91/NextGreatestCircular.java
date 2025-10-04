package Day91;

import java.util.Scanner;
import java.util.Stack;

public class NextGreatestCircular {
//  Input: arr = [3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9]
// Output: [10, -1, 6, 6, 2, 6, 7, 7, 9, 9, 10]

static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static int[] next_greatest(int[] arr){
        Stack<Integer> st = new Stack<>();
    
        int[] ngl = new int[arr.length];
        int n = arr.length;
        for(int i = 2*arr.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i%n]) st.pop();
                if(i<arr.length){
                    if(st.isEmpty()) ngl[i] = -1;
                else ngl[i] = st.peek();
                }
                st.push(arr[i%n]);
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
        int[] ngl = next_greatest(arr);
        display(ngl);
        sc.close();
    }
    
}
