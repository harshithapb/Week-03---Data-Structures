import java.util.*;
public class Bubble {

    public  static void bubble(float[] arr ){
        boolean swapped=false;
        for(int i=0;i<=arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    float temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
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
        float[] marks=new float[n];
        System.out.println("Enter ele of arr:");
        for(int i=0;i<n;i++){
            marks[i]=sc.nextFloat();
        }
        System.out.println("Arr before sorting:");
        print(marks);
        System.out.println("\nArr after sorting:");
        bubble(marks);
        print(marks);

    }
}
