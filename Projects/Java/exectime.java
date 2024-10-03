import java.util.Arrays;
import java.util.Random;

public class exectime {

    public static void main(String[] args) {
        System.out.println("Array size\tInsertion\tBubble\tMerge\tQuick\tHeap");
        System.out.println("---------------------------------------------------");
        for (int size : new int[] {50000, 100000, 150000, 200000, 250000, 300000}) {
            int[] array = generateRandomArray(size);
            printExecutionTimes(array);
        }
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000000);
        }
        return array;
    }

    private static void printExecutionTimes(int[] array) {
        int strWidth = 10;
        int[] arrayCopy = array.clone();
        long insertionStart = System.currentTimeMillis();
        insertionSort(arrayCopy);
        long insertionEnd = System.currentTimeMillis();

        arrayCopy = array.clone();
        long bubbleStart = System.currentTimeMillis();
        bubbleSort(arrayCopy);
        long bubbleEnd = System.currentTimeMillis();

        arrayCopy = array.clone();
        long mergeStart = System.currentTimeMillis();
        mergeSort(arrayCopy);
        long mergeEnd = System.currentTimeMillis();

        arrayCopy = array.clone();
        long quickStart = System.currentTimeMillis();
        quickSort(arrayCopy);
        long quickEnd = System.currentTimeMillis();

        arrayCopy = array.clone();
        long heapStart = System.currentTimeMillis();
        heapSort(arrayCopy);
        long heapEnd = System.currentTimeMillis();

        System.out.printf("%9d\t%" + strWidth + "d\t%" + strWidth + "d\t%" + strWidth + "d\t%" + strWidth + "d\t%" + strWidth + "d%n",
                array.length, insertionEnd - insertionStart, bubbleEnd - bubbleStart, mergeEnd - mergeStart, quickEnd - quickStart, heapEnd - heapStart);
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentElement = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > currentElement) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = currentElement;
        }
    }

    private static void bubbleSort(int[] array) {
        boolean swapped;

        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    private static void mergeSort(int[] array) {
        if (array.length > 1) {
            int[] firstHalf = new int[array.length / 2];
            System.arraycopy(array, 0, firstHalf, 0, array.length / 2);
            mergeSort(firstHalf);

            int[] secondHalf = new int[array.length - array.length / 2];
            System.arraycopy(array, array.length / 2, secondHalf, 0, secondHalf.length);

            merge(firstHalf, secondHalf, array);
        }
    }

    private static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2]) {
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list2[current2++];
            }
        }

        while (current1 < list1.length) {
            temp[current3++] = list1[current1++];
        }

        while (current2 < list2.length) {
            temp[current3++] = list2[current2++];
        }
    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int low = left + 1;
        int high = right;

        while (high > low) {
            while (low <= high && array[low] <= pivot) {
                low++;
            }

            while (low <= high && array[high] > pivot) {
                high--;
            }

            if (high > low) {
                int temp = array[high];
                array[high] = array[low];
                array[low] = temp;
            }
        }

        while (high > left && array[high] >= pivot) {
            high--;
        }

        if (pivot > array[high]) {
            array[left] = array[high];
            array[high] = pivot;
            return high;
        } else {
            return left;
        }
    }

    private static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && array[left] > array[largest]) {
            largest = left;
        }

        if (right < size && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, size, largest);
        }
    }
}
