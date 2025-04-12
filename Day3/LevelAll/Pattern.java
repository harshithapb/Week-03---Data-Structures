import java.awt.desktop.SystemSleepEvent;
import java.util.*;
public class Pattern {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of i/p arr");
        int n1=sc.nextInt();
        System.out.println("Enter ele of i/p arr:");
        int[] arr=new int[n1];
        for(int i=0;i<n1;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the size of pattern arr");
        int n2=sc.nextInt();
        System.out.println("Enter ele of i/p arr:");
        int[] pattern=new int[n2];
        for(int i=0;i<n2;i++){
            pattern[i]=sc.nextInt();
        }
       // 2 1 2 5 7 1 9 3 6 8 8
        System.out.println("Solving");
        Arrays.sort(arr); int count=0;
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<pattern.length;j++){
                if(arr[i]==pattern[j]){
                    al.add(pattern[j]);
                    arr[i]=-1;
                    count++;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=-1){
                al.add(arr[i]);
            }
            //al.add(arr[i]);
        }
        System.out.println("Sorted arr with pattern");
        for(int i=0;i<al.size();i++){
            System.out.print(al.get(i)+" ");
        }
    }
}
