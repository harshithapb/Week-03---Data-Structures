import java.util.*;
public class Insertion {
    public static void insertion(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int j=i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp=arr[j-1];
                arr[j-1]=arr[j];
                arr[j]=temp;
                j--;
            }
        }
    }
    public  static void print(int[] arr){
        for (int v : arr) {
            System.out.print(v + " ");
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of arr:");
        int n=sc.nextInt();
        int[] empId=new int[n];
        System.out.println("Enter ele of arr:");
        for(int i=0;i<n;i++){
           empId[i]=sc.nextInt();
        }
        System.out.println("Arr before sorting:");
        print(empId);
        System.out.println("\nArr after sorting:");
        insertion(empId);
        print(empId);

    }
}
