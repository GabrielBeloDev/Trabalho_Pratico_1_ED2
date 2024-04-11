package questions;

import sort.Quicksort;
import java.util.Random;

public class SortQuestions_3_questao {

    public static void main(String[] args) {
        int[] tamanhos = {100, 1000, 10000, 100000, 1000000};
        for (int tamanho : tamanhos) {
            Integer[] vetor = geraArrayAleatorio(tamanho);
            int L_otimo = encontraLOtimo(vetor);
            System.out.println("Para N = " + tamanho + ", L ótimo encontrado: " + L_otimo);
        }

        Integer[] vetorPequeno = {5, 3, 2, 1, 4, 7, 6, 9, 8};
        int L = 3; // no caso eu usei o l sendo 3 para exemplo, melhor seria usar o L ótimo encontrado acima

        System.out.println("Vetor antes da ordenação:");
        for (Integer valor : vetorPequeno) {
            System.out.print(valor + " ");
        }

        Quicksort.sort(vetorPequeno, 0, vetorPequeno.length - 1, L);

        System.out.println("\nVetor após a ordenação:");
        for (Integer valor : vetorPequeno) {
            System.out.print(valor + " ");
        }
    }

    private static Integer[] geraArrayAleatorio(int tamanho) {
        Integer[] vetor = new Integer[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(tamanho);
        }
        return vetor;
    }

    private static int encontraLOtimo(Integer[] vetorOriginal) {
        int L_otimo = 0;
        long tempoOtimo = Long.MAX_VALUE;

        for (int L = 1; L <= 100; L++) {
            Integer[] vetorCopia = vetorOriginal.clone();
            long tempoInicio = System.nanoTime();
            Quicksort.sort(vetorCopia, 0, vetorCopia.length - 1, L);
            long tempoFim = System.nanoTime();

            if ((tempoFim - tempoInicio) < tempoOtimo) {
                L_otimo = L;
                tempoOtimo = tempoFim - tempoInicio;
            }
        }

        return L_otimo;
    }
}
