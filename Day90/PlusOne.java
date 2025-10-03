package Day90;

import java.util.Scanner;

public class PlusOne {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void reverse(int[] arr){
        int i = 0;
        int j = arr.length -1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    static int[] add_one(int[] arr){
        reverse(arr);
        int carry = 1;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]+carry < 10){
                arr[i] = arr[i]+carry;
                carry = 0;
                break;
            }
            else{
                arr[i] = 0;
                carry = 1;
            }
        }
        if(carry == 1){
            int[] ans = new int[arr.length+1];
            ans[0] = 1;
            return ans; 
        }
        reverse(arr);
        return arr;

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
        int[] ans = add_one(arr);
        display(ans);
        sc.close();
        
    }
    
}
