package LinearSearch;
import java.util.*;
public class LinearSearch1 {
    public static int findIndex(int[]arr){
        int idx=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                return i;
            }
        }
        return idx;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter len of arr");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int idx=findIndex(arr);
        System.out.println("Index of first negative number:"+idx);

    }

}
