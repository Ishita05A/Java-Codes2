package Day85;


import java.util.Scanner;

public class removeElements {
    static  int remove(int[] nums, int val) {
        int k = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i] != val){
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(remove(arr,3));
        sc.close();
    }
    
}
