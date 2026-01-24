package Day162;
import java.util.*;
import java.util.Scanner;

public class GCD {
    static List<Integer> gcd(int n,int m){
        List<Integer> ans = new ArrayList<>();
        int i = 1;
        while(i<n && i<m){
            if(n%i == 0 && n%i == 0){
                 ans.add(i);
                 
            } 
            i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st number");
        int n = sc.nextInt();
        System.out.println("Enter 2nd number ");
        int m = sc.nextInt();
        System.out.println(gcd(n, m));
        sc.close();

    }
    
}
