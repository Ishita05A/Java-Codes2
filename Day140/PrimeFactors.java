package Day140;
import java.util.*;
import java.util.Scanner;

public class PrimeFactors {
    static boolean isPrime(int n){
        int count = 0;
        for(int i = 1;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                count++;
                if(n/i !=i) count++;
            }
        }
        if(count == 2) return true;
        return false;
    }
    static List<Integer> prime_factor_brute(int n){
        List<Integer> ans = new ArrayList<>();
        for(int i = 1;i<Math.sqrt(n);i++){
            if(n%i == 0) {
                if(isPrime(i)) ans.add(i);
                if(n/i !=i){
                    if(isPrime(n/i)) ans.add(n/i);
                }
            } 
        }
        return ans;
    }
    static List<Integer> prime_factor1(int n){
        List<Integer> ans = new ArrayList<>();
        for(int i = 2;i<Math.sqrt(n);i++){
            if(n%i == 0) {
                ans.add(i);
                while(n%i == 0) n/=i;
            } 
        }
        if(n != 1) ans.add(n);
        return ans;
    }
    static List<Integer> primeFactor(int n){
        List<Integer> ans = new ArrayList<>();
        for(int i = 2;i<=n;i++){
            if(n%i == 0){
                ans.add(i);
                while(n%i == 0) n/=i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        System.out.println(prime_factor_brute(n));
        System.out.println(primeFactor(n));
        System.out.println(prime_factor1(n));
        sc.close();
    }
    
}
