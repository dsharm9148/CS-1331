import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Utility for getting arrays to test sorting algorithms.
 * @author Dongjae Lee
 * @version 13.31
 */
public class ArrayGenerator {
    public static final String[] NATO_ALPHABET_UNSORTED = {
        "Alfa", "Charlie", "Bravo", "Echo", "Delta",
        "India", "Lima", "Juliett", "Kilo", "Mike", "Oscar", 
        "November", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Foxtrot", 
        "Golf", "Hotel", "Uniform", "Victor", "Whiskey", "X-ray", "Yankee", "Zulu"
    };

    /**
     * Creates and returns an array filled with random values.
     * @param size number of elements in returned array
     * @return array filled with random values
     */
    public static Integer[] generateRandomIntArray(int size) {
        Integer[] array = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    /**
     * Returns an array whose contents are read in from the specified file.
     * @param filename file to read data from, where file's content is separated by newlines
     * @return array including elements from provided file 
     */
    public static Integer[] integerArrayFromFile(String filename) {
        ArrayList<Integer> list = new ArrayList<>();
        
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while (scan.hasNextInt()) {
                list.add(scan.nextInt());
            }  
        } catch (IOException e) {
            System.out.println(e);
        }

        Integer[] arr = list.toArray(new Integer[list.size()]);

        return arr;
    }

    /**
     * Prints the input array.
     * @param arr array to print
     */
    public static void arrayPrinter(Object[] arr) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("{");
        for (Object element : arr) {
            sb.append(element).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()).append("}");

        System.out.println(sb.toString());
    }
}