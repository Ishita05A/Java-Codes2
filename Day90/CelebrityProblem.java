package Day90;

import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {
    static int FindCelebrity(int[][] arr){
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<arr.length;i++){
            st.push(i);
        }
        while(st.size()>1){
            int v1 = st.pop();
            int v2 = st.pop();
            if(arr[v1][v2] == 0) st.push(v1);
            if(arr[v2][v1] == 0) st.push(v2);
        }
        if(st.size() == 0) return -1;
        int potential = st.pop();

        for(int j = 0;j<arr.length;j++){
            if(arr[potential][j] != 0) return -1;
        }
        for(int i = 0; i<arr.length;i++){
            if(i == potential) continue;
            if(arr[i][potential] != 1) return -1;
        }
        return potential;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows and columns");
        int n = sc.nextInt();
        
        int[][] arr = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(FindCelebrity(arr));
        sc.close();


    }
    
}
