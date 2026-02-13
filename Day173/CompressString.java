package Day173;

import java.util.Scanner;

public class CompressString {
    static int compressedString(char[] arr){
        String str = new String(arr);
        int n = arr.length;
        StringBuilder  a = new StringBuilder();
        a.append(str.charAt(0));
        int count = 1;
        StringBuilder  ans = new StringBuilder();
        for(int i = 1;i<n;i++){
           while(i<n && str.charAt(i) == a.charAt(a.length()-1)){
            count++;
            i++;
           }
           a.append(count);
           ans.append(a);
           a =new StringBuilder();
           if(i<n) a.append(str.charAt(i));
           count = 1;
        }
        System.out.println(ans);
        return ans.length();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of elements");
        int n = sc.nextInt();
        System.out.println("Enter Characters");
        char[] arr = new char[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.next().charAt(0);
        }
        System.out.println(compressedString(arr));
        sc.close();


    }
    
}
