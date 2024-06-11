package sort;

public class BubbleSort {

    public static <T extends Comparable<T>> void sort(T[] vetor, int inicio, int fim) {
        // comparando e trocando elementos adjacentes se existirem ordem e trocar as suas posições se existirem na ordem errada, maior indo para o final do array)
        for (int i = inicio; i <= fim; i++) {
            for (int j = inicio; j < fim - i + inicio; j++) {
                if (vetor[j].compareTo(vetor[j + 1]) > 0) {
                    T temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }
}
