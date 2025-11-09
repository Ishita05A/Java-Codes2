package Day110;

import java.util.ArrayList;
import java.util.Scanner;

public class followupAlterate {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void followUp(int[] arr){
        
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            if(arr[i] >=0) pos.add(arr[i]);
            else neg.add(arr[i]);
        }
        int i = 0;
        int k = 0;
        while(i<pos.size() && i<neg.size()){
            arr[k++] = pos.get(i);
            arr[k++] = neg.get(i);
            i++;
        }
        while(i<pos.size()){
            arr[k++] = pos.get(i++);
        }
        while(i<neg.size()){
            arr[k++] = neg.get(i++);
        }
        

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
        followUp(arr);
        display(arr);
        sc.close();
        
    }
    
}
