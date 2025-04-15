package StringBuilder;

import java.util.HashSet;
import java.util.Scanner;

public class StringBuilder2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter str to remove duplicates ");
        String s=sc.nextLine();
        StringBuilder sb=new StringBuilder(" ");
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<s.length();i++){
            hs.add(s.charAt(i));
        }
        for(int i=0;i<s.length();i++){
            if(hs.contains(s.charAt(i))){
                sb.append(s.charAt(i));
                hs.remove(s.charAt(i));
            }

        }

        System.out.println("str after removing duplicates: "+sb);
    }
}
