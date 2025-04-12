import java.util.*;
public class MergeSort {
    public static void merge(float[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        ArrayList<Float> al = new ArrayList<>();
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                al.add(arr[left]);
                left++;
            }
            else{
                al.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            al.add(arr[left]);
            left++;
        }
        while (right <= high) {
            al.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            arr[i]=al.get(i-low);
        }
    }

    public static void print(float[] arr) {
        for (float v : arr) {
            System.out.print(v + " ");
        }
    }

    public static void mergeSort(float[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = ((low + high) / 2);
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of arr:");
        int n = sc.nextInt();
        float[] price = new float[n];
        System.out.println("Enter ele of arr:");
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextFloat();
        }
        System.out.println("Arr before sorting:");
        print(price);
        System.out.println("\nArr after sorting:");
        mergeSort(price, 0, price.length-1);
        print(price);

    }
}
