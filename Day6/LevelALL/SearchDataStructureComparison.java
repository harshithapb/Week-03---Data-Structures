
import java.util.*;
public class SearchDataStructureComparison {

    private static final int DATASET_SIZE = 1000000;
    private static List<Integer> arrayList;
    private static Set<Integer> hashSet;
    private static Set<Integer> treeSet;
    private static int targetElement;

    public static void main(String[] args) {
        // Initialize the data structures with the same data
        List<Integer> data = generateRandomData(DATASET_SIZE);
        arrayList = new ArrayList<>(data);
        hashSet = new HashSet<>(data);
        treeSet = new TreeSet<>(data);
        targetElement = data.get(new Random().nextInt(DATASET_SIZE));

        System.out.println("Dataset Size: " + DATASET_SIZE);
        System.out.println("Target Element: " + targetElement);
        System.out.println("----------------------------------");

        measureSearchTime("Array Search", () -> arrayList.contains(targetElement));
     s   measureSearchTime("HashSet Search", () -> hashSet.contains(targetElement));
        measureSearchTime("TreeSet Search", () -> treeSet.contains(targetElement));
    }

    public static List<Integer> generateRandomData(int size) {
        List<Integer> data = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data.add(random.nextInt(size * 10)); // Generate random numbers
        }
        return data;
    }

    public static void measureSearchTime(String searchType, Runnable searchOperation) {
        long startTime = System.nanoTime();
        searchOperation.run();
        long endTime = System.nanoTime();
        long durationMillis = (endTime - startTime) / 1_000_000.0;
        System.out.println(searchType + ": Time taken = " + durationMillis + " ms");
    }
}



