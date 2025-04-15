package InputStreamReader;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
public class InputStreamReader1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String filepath="src/InputStreamReader/File1.txt";
        try{
            FileInputStream file=new FileInputStream(filepath);
            InputStreamReader ip=new InputStreamReader(file, StandardCharsets.UTF_8);

            BufferedReader reader= new BufferedReader(ip);
            String line;
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
