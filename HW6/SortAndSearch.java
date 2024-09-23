/**
 * Provides sorting and searching algorithm implementations.
 * @author Diya Sharma
 * @version 13.31
 */

public class SortAndSearch {
    /**
     * Returns index where element exists in array.
     * @param <T> Type of Objects in array
     * @param arr Array of Objects to search
     * @param toFind Element to search for
     * @return Index where element is found, or -1 if element is not found
     */
    public static <T extends Comparable<T>> int linearSearch(T[] arr, T toFind) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(toFind)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Searches an array sorted in ascending order and returns index where element exists in array.
     * @param <T> Type of Objects in array
     * @param arr Array to search, sorted in ascending order
     * @param toFind Element to search for
     * @return Index where element is found, or -1 if element is not found
     */
    public static <T extends Comparable<T>> int binarySearch(T[] arr, T toFind) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid].compareTo(toFind) == 0) {
                return mid;
            } else if (arr[mid].compareTo(toFind) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Sorts array in ascending order.
     * @param <T> Type of Objects to sort
     * @param arr The array of Objects to sort
     */
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * Sorts array in ascending order.
     * @param <T> Type of Objects to sort
     * @param arr The array of Objects to sort
     */
    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Sorts array in ascending order.
     * @param <T> Type of Objects to sort
     * @param arr The array of Objects to sort
     */
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Sorts the specified range of the array.
     *
     * @param <T>   Type of Objects to sort
     * @param arr   The array of Objects to sort
     * @param temp  The temporary array used for merging
     * @param low   The index of the first element in the range to be sorted
     * @param high  The index of the last element in the range to be sorted
     */
    private static <T extends Comparable<T>> void mergeSort(T[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    /**
     * Merges two sorted subarrays into one sorted array.
     *
     * @param <T>   Type of Objects to sort
     * @param arr   The array containing the elements to be merged
     * @param temp  The temporary array used for merging
     * @param low   The index of the first element of the first subarray
     * @param mid   The index of the last element of the first subarray
     * @param high  The index of the last element of the second subarray
     */
    private static <T extends Comparable<T>> void merge(T[] arr, int low, int mid, int high) {
        int leftLength = mid - low + 1;
        int rightLength = high - mid;
        T[] leftArray = (T[]) new Comparable[leftLength];
        T[] rightArray = (T[]) new Comparable[rightLength];

        for (int i = 0; i < leftLength; ++i) {
            leftArray[i] = arr[low + i];
        }
        for (int j = 0; j < rightLength; ++j) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = low;
        while (i < leftLength && j < rightLength) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }
        while (i < leftLength) {
            arr[k++] = leftArray[i++];
        }
        while (j < rightLength) {
            arr[k++] = rightArray[j++];
        }
    }
}