package questions;

import sort.SelectSort;

public class SortQuestions_2_questao {
    public static void main(String[] args) {
        System.out.println("Teste do SelectSort melhorado:");
        Integer[] selectArray = generateRandomArray(30);
        System.out.println("Array original:");
        printArray(selectArray);

        SelectSort.improvedSelectSort(selectArray);
        System.out.println("Array após SelectSort melhorado:");
        printArray(selectArray);

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

    private static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

//    private static void testVariousSizes() {
//        int[] sizes = {1, 10, 100, 1000, 10000, 100000, 300000};
//        for (int size : sizes) {
//            long startTime = System.currentTimeMillis();
//
//            Integer[] array = generateRandomArray(size);
//            SelectSort.improvedSelectSort(array);
//            boolean isSorted = isSorted(array);
//
//            long endTime = System.currentTimeMillis();
//            long duration = endTime - startTime;
//
//            String result;
//
//            if (isSorted(array)) {
//                result = String.format("SelectSort melhorado com %,d elementos: PASSOU. Tempo de execução: %d ms", size, duration);
//            } else {
//                result = String.format("SelectSort melhorado com %,d elementos: FALHOU. Tempo de execução: %d ms", size, duration);
//            }
//
//            System.out.println(result);
//        }
//    }
//
//    private static boolean isSorted(Integer[] array) {
//        for (int i = 0; i < array.length - 1; i++) {
//            if (array[i] > array[i + 1]) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
