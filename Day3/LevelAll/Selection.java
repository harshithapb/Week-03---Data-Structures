import java.util.Scanner;

public class Selection {
    public static void selection(float[] arr){
        for(int i=0;i<arr.length-1;i++){
            int mini=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[mini]){
                    mini=j;
                }
            }
            float temp=arr[mini];
            arr[mini]=arr[i];
            arr[i]=temp;
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
        float[] score=new float[n];
        System.out.println("Enter ele of  score arr:");
        for(int i=0;i<n;i++){
            score[i]=sc.nextFloat();
        }
        System.out.println("Arr before sorting:");
        print(score);
        System.out.println("\nArr after sorting:");
        selection(score);
        print(score);

    }
}
