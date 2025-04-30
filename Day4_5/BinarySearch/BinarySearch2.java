package BinarySearch;
import java.util.*;
public class BinarySearch2 {
    public static int findPeek(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid=left+(left+right/2);
            boolean leftHalf=(mid==0|| arr[mid]>arr[mid-1]);
            boolean rightHalf=(mid==arr.length-1|| arr[mid]<arr[mid+1]);
            if( leftHalf&&rightHalf ){
                return arr[mid];
            }
            else if(arr[mid+1]>arr[mid]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int peak = findPeek(arr);
        System.out.println("A peak element is: " + peak);

    }
}
