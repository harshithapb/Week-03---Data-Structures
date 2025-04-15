package StringBuffer;
import java.util.*;
public class StringBuffer1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length of arr");
        int n=sc.nextInt();
        String[] arr=new String[n];
        System.out.println("Enter ele of arr");
        for(int i=0;i<n;i++){
            arr[i]=sc.next();
        }
        StringBuffer sb=new StringBuffer();
        for(String str : arr){
            sb.append(str);
            System.out.println("Arr after concat :"+sb);
        }
        System.out.println("Final ans after concat :"+sb);
    }
}
//hello it is good to see you doing well