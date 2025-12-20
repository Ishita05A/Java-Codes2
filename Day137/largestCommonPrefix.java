package Day137;
import java.util.*;
import java.util.Scanner;

public class largestCommonPrefix {
    static String commonPrefix(String[] str){
        Arrays.sort(str);
        StringBuilder ans = new StringBuilder();
        char[] first = str[0].toCharArray();
        char[] last = str[str.length-1].toCharArray();
        for(int i = 0;i<Math.min(first.length, last.length);i++){
            if(first[i] != last[i]){
                break;
            }
            ans.append(first[i]);
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of elements");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Strings ");
        String[] str = new String[n];
        for(int i = 0;i<n;i++){
            str[i] = sc.next();
        }
        System.out.println(commonPrefix(str));
        sc.close();

    }
    
}
