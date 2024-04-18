package questions;
import sort.DoubleHeapSort;

import java.util.Arrays;
import java.util.Random;

public class SortQuestions_4_questao {
    public static void main(String[] args) {
        int tamanhoDoArray = 20;
        Integer[] arrayOriginal = new Integer[tamanhoDoArray];
        Random aleatorio = new Random();

        for (int i = 0; i < tamanhoDoArray; i++) {
            arrayOriginal[i] = aleatorio.nextInt(100);  // Números aleatórios de 0 a 99
        }

        Integer[] arraySemThreads = Arrays.copyOf(arrayOriginal, tamanhoDoArray);
        Integer[] arrayComThreads = Arrays.copyOf(arrayOriginal, tamanhoDoArray);

        DoubleHeapSort<Integer> sorter = new DoubleHeapSort<>();

        System.out.println("Array original para teste sem threads:");
        System.out.println(Arrays.toString(arraySemThreads));

        long tempoInicial = System.currentTimeMillis();
        sorter.doubleHeapSort(arraySemThreads, false);
        long tempoFinal = System.currentTimeMillis();

        System.out.println("Array ordenado sem threads:");
        System.out.println(Arrays.toString(arraySemThreads));
        System.out.println("Duração sem threads: " + (tempoFinal - tempoInicial) + " milissegundos.");

        System.out.println("Array original para teste com threads:");
        System.out.println(Arrays.toString(arrayComThreads));

        tempoInicial = System.currentTimeMillis();
        sorter.doubleHeapSort(arrayComThreads, true);
        tempoFinal = System.currentTimeMillis();

        System.out.println("Array ordenado com threads:");
        System.out.println(Arrays.toString(arrayComThreads));
        System.out.println("Duração com threads: " + (tempoFinal - tempoInicial) + " milissegundos.");
    }
}
