
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class LargeFileReadingComparison {

    private static final String LARGE_FILE_PATH = "D:\Freq ques";

    public static void main(String[] args) {
        testFileReaderEfficiency();
        testInputStreamReaderEfficiency();
    }

    public static void testFileReaderEfficiency() {
        long startTime = System.nanoTime();
        try (FileReader fileReader = new FileReader(LARGE_FILE_PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.readLine() != null) {
                // Reading line by line
            }
        } catch (IOException e) {
            System.err.println("Error reading with FileReader: " + e.getMessage());
        }
        long endTime = System.nanoTime();
        long durationMillis = (endTime - startTime) / 1_000_000;
        System.out.println("Time taken by FileReader: " + durationMillis + " ms");
    }

    public static void testInputStreamReaderEfficiency() {
        long startTime = System.nanoTime();
        try (FileInputStream fileInputStream = new FileInputStream(LARGE_FILE_PATH);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            while (bufferedReader.readLine() != null) {
                // Reading line by line
            }
        } catch (IOException e) {
            System.err.println("Error reading with InputStreamReader: " + e.getMessage());
        }
        long endTime = System.nanoTime();
        long durationMillis = (endTime - startTime) / 1_000_000;
        System.out.println("Time taken by InputStreamReader: " + durationMillis + " ms");
    }
}


