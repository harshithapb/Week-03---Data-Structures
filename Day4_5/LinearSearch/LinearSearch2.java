package LinearSearch;

import java.util.Scanner;

public class LinearSearch2 {
    public static String findSentence(String[] sentences,String word){
        for(String str: sentences){
            if(str.contains(word)){
                return str;
            }
        }
        return "Not Found";
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of sentences");
        int n=Integer.parseInt(sc.nextLine());
        System.out.println("Enter sentences");
        String[] sentences=new String[n];
        for (int i=0;i<n;i++){
            sentences[i]=sc.nextLine();
        }
        System.out.print("Enter word to search: ");
        String word = sc.nextLine();
        String result = findSentence(sentences, word);
        System.out.println("Result: " + result);
    }
}
