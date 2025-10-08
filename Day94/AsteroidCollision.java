package Day94;

import java.util.Scanner;
import java.util.Stack;

public class AsteroidCollision {
    static int[] asteriod_collision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                st.push(arr[i]);
            else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(arr[i]))
                    st.pop();
                if (!st.isEmpty() && st.peek() == Math.abs(arr[i]))
                    st.pop();
                else if (st.isEmpty() || st.peek() < 0)
                    st.push(arr[i]);

            }
        }
        int[] ans = new int[st.size()];
        for(int i = ans.length-1;i>=0;i--) ans[i] = st.pop();
        return ans;
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
        int[] ans = asteriod_collision(arr);
        for(int i = 0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
        sc.close();
    }

}
