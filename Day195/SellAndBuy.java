package Day195;

public class SellAndBuy {
    static int sellAndBuy(int[] arr){
        int n = arr.length-1;
        int sell = arr[n-1];
        int max = -1;
        for(int i = n-2;i>=0;i--){
            max = Math.max(max, sell-arr[i]);
            sell = Math.max(arr[i], sell);
        }
        return max;

    }
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(sellAndBuy(arr));
    }
    
}
