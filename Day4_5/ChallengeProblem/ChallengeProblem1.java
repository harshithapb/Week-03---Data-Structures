package ChallengeProblem;
import java.io.*;
import java.util.*;
public class ChallengeProblem1 {
    public static void main(String[] args){
        String str="hello";
        StringBuilder sbuilder=new StringBuilder();
        StringBuffer sbuffer=new StringBuffer();
        int n=1000000;

        long timeBuilderStart=System.nanoTime();
        for(int i=0;i<n;i++){
            sbuilder.append(str);
        }
        long timeBuilderEnd=System.nanoTime();

        long timeBufferStart=System.nanoTime();
        for(int i=0;i<n;i++){
            sbuilder.append(str);
        }
        long timeBufferEnd=System.nanoTime();

        System.out.println("Time taken by StringBuilder :"+(timeBuilderEnd-timeBuilderStart));
        System.out.println("Time taken by StringBuffer :"+(timeBufferEnd-timeBufferStart));
        String filepath="src/FileReader/File2.txt";
        try{
            FileReader file=new FileReader(filepath);
            BufferedReader reader =new BufferedReader(file);
            int wordCount=0;
            String line;
            long startFile=System.nanoTime();
            while((line=reader.readLine())!=null){
                String[] words=line.split("\\w+");
                wordCount+=words.length;
            }
            long endFile=System.nanoTime();
            System.out.println("Time taken by FileReader :"+(endFile-startFile));

            FileInputStream istream=new FileInputStream(filepath);
            InputStreamReader ip=new InputStreamReader(istream);
            BufferedReader buffer=new BufferedReader(ip);
            String line2;
            int count=0;
            long startInput=System.nanoTime();
            while((line2=buffer.readLine())!=null){
                String [] words2=line2.split("\\w+");
                count+=words2.length;
            }
            long endInput=System.nanoTime();
            System.out.println("Time taken by BufferedReader :"+(endInput-startInput));

        }
        catch(IOException e){
            System.out.println("Error reading file: "+e.getMessage());
        }

    }

}
