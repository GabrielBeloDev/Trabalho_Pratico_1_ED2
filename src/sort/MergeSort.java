package sort;

public class MergeSort {


    public static <T extends Comparable<T>> T[] mergeSort(T[] A) {
        T[] temp = A.clone();
        mergeMain(A, temp, 0, A.length - 1);
        return A;
    }

    private static <T extends Comparable<T>> T[] mergeMain(T[] A, T[] T, int esq, int dir) {
        int meio = (esq + dir) / 2;
        if (esq < dir) {
            if ((dir - esq + 1) <= 15) {
                insertSort(A, esq, dir);
            } else {
                mergeMain(A, T, esq, meio);
                mergeMain(A, T, meio + 1, dir);
                if (A[meio].compareTo(A[meio + 1]) >= 0) {
                    Merge(A, T, esq, meio + 1, dir);
                }
            }
        }
        return A;
    }


    public static <T extends Comparable<T>> T[] Merge(T[] A, T[] T, int esqPos, int dirPos, int dirFim) {
        int esqFim = dirPos - 1;
        int temPos = esqPos;
        int numElem = dirFim - esqPos + 1;

        while (esqPos <= esqFim && dirPos <= dirFim) {
            if (A[esqPos].compareTo(A[dirPos]) <= 0)
                T[temPos++] = A[esqPos++];
            else
                T[temPos++] = A[dirPos++];
        }
        while (esqPos <= esqFim) {
            T[temPos++] = A[esqPos++];
        }
        while (dirPos <= dirFim) {
            T[temPos++] = A[dirPos++];
        }

        for (int i = 0; i < numElem; i++, dirFim--) {
            A[dirFim] = T[dirFim];
        }
        return A;
    }

    // InsertSort usado para pequenos subvetores.
    private static <T extends Comparable<T>> T[] insertSort(T[] A, int esq, int dir) {
        for (int j = esq; j <= dir; j++) {
            T key = A[j];
            int i = j - 1;
            while (i >= esq && A[i].compareTo(key) > 0) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
        return A;
    }
}
