package InputStreamReader;
import java.util.*;
import java.io.*;
public class InputStreamReader2 {
    public static void main(String[] args){
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader reader=new BufferedReader(ip);
        String filepath="src/InputStreamReader/InputFilePgm2.txt";

        FileWriter writer =null;
        try{
            writer=new FileWriter(filepath);
            String line;
            while((line=reader.readLine())!=null  && !line.equalsIgnoreCase("exit")){
                writer.write(line);
                writer.write(System.lineSeparator());
            }
            System.out.println("Input finished and written to " + filepath);
        }
        catch(IOException e){
            e.getMessage();
        }
        finally{
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            }
            catch(IOException e1){
                    System.out.println(e1.getMessage());

                }
            }
        }
    }



