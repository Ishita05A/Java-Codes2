package Day159;

import java.util.Scanner;

public class LemonadeChange {
    static boolean isChangePossible(int[] arr){
        int ten = 0,five = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 5) five++;
            else if(arr[i] == 10){
                if(five >=1){
                    five--;
                    ten++;
                }
                else return false;
            }
            else if(arr[i] == 20){
                if(five >=3) five-=3;
                else if(five>=1 && ten >=1){
                    five--;
                    ten--;
                }
                else return false;
            }

        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements for value");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(isChangePossible(arr));
        sc.close();

    }
    
}
