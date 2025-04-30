package BinarySearch;
import java.util.*;
public class BinarySearch1 {
    public static int findRotationPoint(int [] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(start+end/2);
            if(arr[mid]>arr[end]){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return start;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of rotated sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int index = findRotationPoint(arr);
        System.out.println("Index of smallest element (rotation point): " + index);

    }

}
