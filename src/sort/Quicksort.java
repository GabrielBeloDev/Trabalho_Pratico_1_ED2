package sort;

public class Quicksort {

    public static <T extends Comparable<T>> void sort(T[] vetor, int inicio, int fim, int L) {
        if (inicio < fim) {
            if (fim - inicio + 1 <= L) {
                BubbleSort.sort(vetor, inicio, fim);
            } else {
                int posicaoPivo = particiona(vetor, inicio, fim);
                sort(vetor, inicio, posicaoPivo - 1, L);
                sort(vetor, posicaoPivo + 1, fim, L);
            }
        }
    }

    private static <T extends Comparable<T>> int particiona(T[] vetor, int inicio, int fim) {
        T pivo = medianaDeTres(vetor, inicio, fim);
        int esquerda = inicio;
        int direita = fim - 1;

        while (true) {
            while (esquerda < fim && vetor[++esquerda].compareTo(pivo) < 0);
            while (direita > inicio && vetor[--direita].compareTo(pivo) > 0);

            if (esquerda >= direita) {
                break;
            } else {
                troca(vetor, esquerda, direita);
            }
        }
        troca(vetor, esquerda, fim - 1);
        return esquerda;
    }

    private static <T extends Comparable<T>> T medianaDeTres(T[] vetor, int inicio, int fim) {
        int centro = (inicio + fim) / 2;

        if (vetor[inicio].compareTo(vetor[centro]) > 0)
            troca(vetor, inicio, centro);

        if (vetor[inicio].compareTo(vetor[fim]) > 0)
            troca(vetor, inicio, fim);

        if (vetor[centro].compareTo(vetor[fim]) > 0)
            troca(vetor, centro, fim);

        troca(vetor, centro, fim - 1);
        return vetor[fim - 1];
    }

    private static <T> void troca(T[] vetor, int i, int j) {
        T temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}
