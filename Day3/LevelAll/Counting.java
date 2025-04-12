public class Counting {
    public static void counting(int[] arr){
        int n=arr.length;
        int[] count=new int[9]; // 18-10+1

        for(int i=0;i<n;i++){
            count[arr[i]-10]++;
        }
        //cumulative age taken
        for(int i=1;i<9;i++){
            count[i]+=count[i-1];
        }

        //new array for displaying correct ele of count sort
        int[] op=new int[arr.length];
        for(int i=n-1;i>=0;i--){
            op[count[arr[i]-10]-1]=arr[i];
            count[arr[i]-10]--;
        }
        System.out.println("Sorted ages are");
        for(int i=0;i<op.length;i++){
            System.out.print(op[i]+" ");
        }

    }
    public static void main(String[] args){
        int[] studentAges = {12, 10, 15,11,11,12, 11, 13, 18, 16, 14, 17};
        counting(studentAges);
    }
}
