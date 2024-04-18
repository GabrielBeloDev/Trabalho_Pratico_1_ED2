package sort;

public class SelectSort {

    // versão melhorada do SelectSort que seleciona o maior e o menor na mesma iteração.
    public static <T extends Comparable<T>> void improvedSelectSort(T[] A) {
        for (int i = 0, j = A.length - 1; i <= j; i++, j--) {
            int min = i;
            int max = j;
            if (A[min].compareTo(A[max]) > 0) {
                T temp = A[min];
                A[min] = A[max];
                A[max] = temp;
            }
            for (int k = i + 1; k < j; k++) {
                if (A[k].compareTo(A[min]) < 0) {
                    min = k;
                }
                if (A[k].compareTo(A[max]) > 0) {
                    max = k;
                }
            }
            if (min != i) {
                T temp = A[min];
                A[min] = A[i];
                A[i] = temp;
            }
            if (max != j) {
                T temp = A[max];
                A[max] = A[j];
                A[j] = temp;
            }
        }
    }
}
