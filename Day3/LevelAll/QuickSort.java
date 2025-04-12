import java.util.Scanner;

public class QuickSort {
    public static int pivotIndex(float[] arr, int low,int high){
        float pivot=arr[low];
        int i=low;
        int j=high;
        while(i<j){
            while(arr[i]<=pivot && i<=high ){
                i++;
            }
            while(arr[j]>pivot && j>=low+1){
                j--;
            }
            if(i<j){
                float temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;j--;
            }
        }
        float temp=arr[low];
        arr[low]=arr[j];
        arr[j]=temp;
        return j;
    }

    public static void quickSort(float[] arr, int low,int high){
        if(low<high){
            int pIdx=pivotIndex(arr,low,high);
            quickSort(arr,low,pIdx-1);
            quickSort(arr,pIdx+1,high);
        }

    }
    public  static void print(float[] arr){
        for (float v : arr) {
            System.out.print(v + " ");
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of arr:");
        int n=sc.nextInt();
        float[] prices=new float[n];
        System.out.println("Enter ele of arr:");
        for(int i=0;i<n;i++){
            prices[i]=sc.nextFloat();
        }
        System.out.println("Arr before sorting:");
        print(prices);
        System.out.println("\nArr after sorting:");
        quickSort(prices,0,prices.length-1);
        print(prices);

    }
}
