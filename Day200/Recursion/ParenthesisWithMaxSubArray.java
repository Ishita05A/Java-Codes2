package Day200.Recursion;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisWithMaxSubArray {
    static class Pair{
        char top;
        int idx;
        Pair(char top,int idx){
            this.top = top;
            this.idx = idx;
        }
    }
    static void prefixSum(int[] arr){
        for(int i = 1;i<arr.length;i++){
            arr[i] += arr[i-1];
        }
    }
    static int maxSubArraySum(char[] s,int[] arr){
        Stack<Pair> st = new Stack<>();
        int n = arr.length;
        int i = 0;
        int sum = 0;
        prefixSum(arr);
        while(i<n){
            if(s[i] == '(' || s[i] == '{' || s[i] == '['){
                st.push(new Pair(s[i], i));
            }
            else{
                Pair it = st.peek(); 
                int top = it.top;
                int idx = it.idx;
                if(st.isEmpty()) return sum;
                else if((top == '(' && s[i] == ')') || (top == '{' && s[i] == '}' || (top == '[' && s[i] == ']'))){
                    st.pop();
                    if(idx > 0)sum+=(arr[i]- arr[idx-1]);
                    else sum+=arr[i];
                    if(sum<0) sum = 0;
                }
                else return sum;
            }
            i++;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		    char[] str = new char[n];
		    int[] arr = new int[n];
		    for(int i = 0;i<n;i++){
		        str[i] = sc.next().charAt(0);
		    }
		    for(int i= 0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
            sc.close();
    }
    
}
