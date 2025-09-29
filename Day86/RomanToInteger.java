package Day86;

import java.util.HashMap;
import java.util.Scanner;

public class RomanToInteger {
    static int romanToInt(String s) {
        HashMap<Character,Integer> mp = new HashMap<>();
        
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        char ch = s.charAt(s.length()-1);
        int sum = mp.get(ch);
        for(int i = s.length()-2;i>=0;i--){
            char curr = s.charAt(i);
            char prev = s.charAt(i+1);
            if(mp.get(curr)<mp.get(prev)) sum-=mp.get(curr);
            else sum+=mp.get(curr);
        }
        return sum;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Expression");
        String str = sc.nextLine();
        System.out.println(romanToInt(str));
        sc.close();
    }
    
}
