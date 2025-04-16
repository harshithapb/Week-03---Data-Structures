
public class StringConcatenationBenchmark {

    private static final int NUMBER_OF_STRINGS = 1000000;
    private static final String STRING_TO_APPEND = "test";

    public static void main(String[] args) {
        testStringConcatenation();
        testStringBuilderConcatenation();
        testStringBufferConcatenation();
    }

    public static void testStringConcatenation() {
        long startTime = System.nanoTime();
        String result = "";
        for (int i = 0; i < NUMBER_OF_STRINGS; i++) {
            result += STRING_TO_APPEND;
        }
        long endTime = System.nanoTime();
        long durationMillis = (endTime - startTime) / 1_000_000;
        System.out.println("Time taken for String concatenation: " + durationMillis + " ms");
    }

    public static void testStringBuilderConcatenation() {
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_STRINGS; i++) {
            sb.append(STRING_TO_APPEND);
        }
        String result = sb.toString();
        long endTime = System.nanoTime();
        long durationMillis = (endTime - startTime) / 1_000_000;
        System.out.println("Time taken for StringBuilder concatenation: " + durationMillis + " ms");
    }

    public static void testStringBufferConcatenation() {
        long startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < NUMBER_OF_STRINGS; i++) {
            sbf.append(STRING_TO_APPEND);
        }
        String result = sbf.toString();
        long endTime = System.nanoTime();
        long durationMillis = (endTime - startTime) / 1_000_000;
        System.out.println("Time taken for StringBuffer concatenation: " + durationMillis + " ms");
    }
}

