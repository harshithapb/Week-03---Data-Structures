package StringBuilder;

import java.util.Scanner;

public class StringBuilder1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter str to reverse ");
        String s=sc.nextLine();
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        System.out.println(" Reversed str : "+sb.toString());
    }
}
