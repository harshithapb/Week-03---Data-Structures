package FileReader;
import java.io.*;
import java.util.*;
public class FileReader2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter word whose freq is to be counted");
        String s= sc.next();
        int n=0;
        String filePath="src/FileReader/File2.txt";
        try(BufferedReader reader =new BufferedReader(new  FileReader(filePath))){
            String line;
            while((line=reader.readLine())!=null){
               String[] words=line.split("\\W+");
               for(int i=0;i<words.length;i++){
                   if(words[i].equalsIgnoreCase(s)){
                       n++;
                   }
               }
            }
            System.out.println("Occurences of "+s+" :"+n);
        }
        catch(IOException e){
            System.out.println("Error encountered :"+e.getMessage());
        }
    }
}
