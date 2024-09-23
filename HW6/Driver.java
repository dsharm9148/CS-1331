/**
 * Driver.
 * @author Diya Sharma
 * @version 13.31
 */
public class Driver {
    /**
    * Driver.
    * @param args args
    */
    public static void main(String[] args) {
        System.out.println("Nato Alphabet Array using Selection: ");
        String[] array1 = ArrayGenerator.NATO_ALPHABET_UNSORTED;
        //ArrayGenerator.arrayPrinter(array1);
        AlgorithmBenchmark.searchAndBenchmark(array1, "Hotel", SearchAlgorithm.LINEAR);
        AlgorithmBenchmark.sortAndBenchmark(array1, SortAlgorithm.SELECTION);
        //ArrayGenerator.arrayPrinter(array1);
        AlgorithmBenchmark.searchAndBenchmark(array1, "Hotel", SearchAlgorithm.BINARY);
        System.out.println("Random Integer Array using Insertion: ");
        Integer[] array2 = ArrayGenerator.generateRandomIntArray(1331);
        //ArrayGenerator.arrayPrinter(array2);
        int value = array2[1155];
        AlgorithmBenchmark.searchAndBenchmark(array2, value, SearchAlgorithm.LINEAR);
        AlgorithmBenchmark.sortAndBenchmark(array2, SortAlgorithm.INSERTION);
        //ArrayGenerator.arrayPrinter(array2);
        AlgorithmBenchmark.searchAndBenchmark(array2, value, SearchAlgorithm.BINARY);
        System.out.println("Pi Integer Array using Merge: ");
        Integer[] array3 = ArrayGenerator.integerArrayFromFile("pi.txt");
        AlgorithmBenchmark.searchAndBenchmark(array3, 348, SearchAlgorithm.LINEAR);
        AlgorithmBenchmark.sortAndBenchmark(array3, SortAlgorithm.MERGE);
        AlgorithmBenchmark.searchAndBenchmark(array3, 348, SearchAlgorithm.BINARY);
    }
}
