
import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in inner loop, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(arr, left, middle);
, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArray[i++];
        }

        while (j < n2) {
            arr[k++] = rightArray[j++];
        }
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] data = generateRandomArray(10); // You can change the size of the array

        int[] arrBubble = Arrays.copyOf(data, data.length);
        int[] arrMerge = Arrays.copyOf(data, data.length);
        int[] arrQuick = Arrays.copyOf(data, data.length);

        System.out.println("Original Array: " + Arrays.toString(data));

        // Bubble Sort
        long startTime = System.nanoTime();
        bubbleSort(arrBubble);
        long endTime = System.nanoTime();
        System.out.println("Bubble Sorted Array: " + Arrays.toString(arrBubble));
        System.out.println("Time taken by Bubble Sort: " + (endTime - startTime) + " nanoseconds");

        System.out.println("--------------------");

        // Merge Sort
        startTime = System.nanoTime();
        mergeSort(arrMerge, 0, arrMerge.length - 1);
        endTime = System.nanoTime();
        System.out.println("Merge Sorted Array: " + Arrays.toString(arrMerge));
        System.out.println("Time taken by Merge Sort: " + (endTime - startTime) + " nanoseconds");

        System.out.println("--------------------");

        // Quick Sort
        startTime = System.nanoTime();
        quickSort(arrQuick, 0, arrQuick.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sorted Array: " + Arrays.toString(arrQuick));
        System.out.println("Time taken by Quick Sort: " + (endTime - startTime) + " nanoseconds");
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100); // Generate random numbers between 0 and 99
        }
        return arr;
    }
}

