package Day172;

import java.util.Scanner;

public class KokoEatingBanana {
    static int maxElement(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num : arr) max = Math.max(max,num);
        return max;
    }
    static int Bouquet(int[] arr,int bloomDay,int flowerReq){
        int countFlower = 0;
        int bouq = 0;
        for(int i = 0;i<arr.length;i++){
            if(bloomDay >= arr[i]) countFlower++;
            else{
                bouq +=countFlower/flowerReq; 
                countFlower  = 0;
            }
            
        }
        return  bouq+countFlower/flowerReq;
    }
    static int noOfBouquet(int[] arr,int m,int k){
        int st = 1;
        int end = maxElement(arr);
        int ans = -1;
        while(st<=end){
            int mid = (st+end)/2;
            int bouq = Bouquet(arr, mid, k);
            if(bouq>=m){
                ans = mid;
                end = mid -1;
            }
            else st = mid + 1;
        }
        return ans;
    }
    
    static int findHour(int[] arr,int noOfBanana){
        int hour = 0;
        for(int i = 0;i<arr.length;i++){
            hour+=(int)Math.ceil(((double)arr[i]/noOfBanana));
        }
        return hour;
    }
    static int findMinBanana(int[] arr,int h){
        int st = 1;
        int end = maxElement(arr);
        int ans = -1;
        while(st<=end){
            int mid = (st+end)/2;
            int hour = findHour(arr, mid);
            if(hour<=h){
                ans = mid;
                end = mid - 1;
            }
            else st = mid + 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // System.out.println(findMinBanana(arr, 8));
        System.out.println(noOfBouquet(arr, 3, 1));
        sc.close();
    }
    
}
