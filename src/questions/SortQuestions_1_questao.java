package questions;

import sort.MergeSort;

public class SortQuestions_1_questao {
    public static void main(String[] args) {
        System.out.println("Teste do MergeSort com corte para subvetores pequenos:");
        Integer[] mergeArray = generateRandomArray(50);
        System.out.println("Array original:");
        printArray(mergeArray);

        MergeSort.mergeSort(mergeArray);
        System.out.println("Array após MergeSort:");
        printArray(mergeArray);

        System.out.println("\nTestando MergeSort em um array já ordenado:");
        Integer[] sortedArray = generateSortedArray(50);
        MergeSort.mergeSort(sortedArray);
        printArray(sortedArray);

        //testVariousSizes();
    }


    private static Integer[] generateRandomArray(int size) {
        java.util.Random random = new java.util.Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }


    private static Integer[] generateSortedArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }


    private static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
//    private static boolean isSorted(Integer[] array) {
//        for (int i = 0; i < array.length - 1; i++) {
//            if (array[i].compareTo(array[i + 1]) > 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static void testVariousSizes() {
//        int[] sizes = {1, 10, 100, 1000, 10000, 100000, 1000000};
//        for (int size : sizes) {
//            long startTime = System.currentTimeMillis();
//
//            Integer[] array = generateRandomArray(size);
//            MergeSort.mergeSort(array);
//            boolean sorted = isSorted(array);
//
//            long endTime = System.currentTimeMillis();
//            long duration = endTime - startTime;
//
//            String result;
//            if (sorted) {
//                result = String.format("Teste com %,d elementos: PASSOU. Tempo de execução: %d ms", size, duration);
//            } else {
//                result = String.format("Teste com %,d elementos: FALHOU. Tempo de execução: %d ms", size, duration);
//            }
//
//            System.out.println(result);
//        }
//    }
}
