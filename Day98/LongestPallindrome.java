package Day98;

import java.util.Scanner;
import java.util.HashMap;

public class LongestPallindrome {
    static int longest_pallindrome(String str){
        HashMap<Character,Integer> mp = new HashMap<>();
        int sum = 0;
        boolean flag = false;
        boolean odd = false;
        for(int i = 0; i<str.length();i++){
            char ch = str.charAt(i);
            if(!mp.containsKey(ch)) mp.put(ch,  1);
            else mp.put(ch,mp.get(ch)+1 );
        }
        for(var e: mp.entrySet()){
            if(e.getValue() % 2 == 0) sum+=e.getValue();
            else{
                if(e.getKey() == 1 && flag == false){
                    sum+=1;
                    flag = true;
                    odd = true;

                }
                else{
                    sum = sum+e.getValue()-1;
                    odd = true;
                    
                }
            }
        }
        if(odd == false) return sum;
        if(flag == true) return sum;
        return sum+1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String str = sc.nextLine();
        System.out.println(longest_pallindrome(str));
        sc.close();
        
    }
    
}
