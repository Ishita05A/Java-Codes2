package Day141;

import java.util.Scanner;

public class NumberOfValidWords {
    static int countValidWord(String s){
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if(!Character.isLetter(s.charAt(i))){
                if(s.charAt(i) == ' ') count++;
                else{
                    while(i< s.length() && s.charAt(i)!= ' '){
                        i++;
                    }
                    i++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String str = sc.nextLine();
        System.out.println(countValidWord(str));
        sc.close();
    }
    
}
