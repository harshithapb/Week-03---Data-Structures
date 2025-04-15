package StringBuffer;
import java.util.*;
public class StringBuffer2 {
    public static void main(String[] args){
        System.out.println("Enter string for concat");
        Scanner sc=new Scanner(System.in);
        StringBuilder sbuild=new StringBuilder();
        StringBuffer sbuff=new StringBuffer();
        String s=sc.next();
        int no=1000000;

        long startTimeBuilder=System.nanoTime();
        for(int i=0;i<no;i++){
            sbuild.append(s);
        }
        long endTimeBuilder=System.nanoTime();

        long startTimeBuffer=System.nanoTime();
        for(int i=0;i<no;i++){
            sbuff.append(s);
        }
        long endTimeBuffer=System.nanoTime();

        long builderTime=endTimeBuilder-startTimeBuilder;
        long bufferTime=endTimeBuffer-startTimeBuffer;

        System.out.println("StringBuilder time:"+builderTime+ "ns");
        System.out.println("StringBuffer time:"+bufferTime+ "ns");


        if(builderTime<bufferTime){
            System.out.println("StringBuilder time faster by :"+(bufferTime-builderTime)+ "ns");
        }
        else{
            System.out.println("StringBuffer time faster by :"+(builderTime-bufferTime)+ "ns");
        }
    }
}
