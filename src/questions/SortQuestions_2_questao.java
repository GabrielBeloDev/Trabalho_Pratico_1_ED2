package questions;

import sort.SelectSort;

public class SortQuestions_2_questao {
    public static void main(String[] args) {
        // Teste para SelectSort melhorado
        System.out.println("Teste do SelectSort melhorado:");
        Integer[] selectArray = generateRandomArray(30);
        System.out.println("Array original:");
        printArray(selectArray);

        SelectSort.improvedSelectSort(selectArray);
        System.out.println("Array após SelectSort melhorado:");
        printArray(selectArray);
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
