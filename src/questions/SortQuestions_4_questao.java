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

//        int[] tamanhos = {1, 10, 100, 1000, 10000, 100000, 1000000};
//        for (int tamanho : tamanhos) {
//            Integer[] arrayTeste = new Integer[tamanho];
//            for (int i = 0; i < tamanho; i++) {
//                arrayTeste[i] = aleatorio.nextInt(100);
//            }
//
//            Integer[] arrayTesteSemThreads = Arrays.copyOf(arrayTeste, tamanho);
//            Integer[] arrayTesteComThreads = Arrays.copyOf(arrayTeste, tamanho);
//
//            tempoInicial = System.currentTimeMillis();
//            sorter.doubleHeapSort(arrayTesteSemThreads, false);
//            tempoFinal = System.currentTimeMillis();
//            System.out.println("Teste sem threads para tamanho " + tamanho + ": " + (tempoFinal - tempoInicial) + " ms");
//
//            tempoInicial = System.currentTimeMillis();
//            sorter.doubleHeapSort(arrayTesteComThreads, true);
//            tempoFinal = System.currentTimeMillis();
//            System.out.println("Teste com threads para tamanho " + tamanho + ": " + (tempoFinal - tempoInicial) + " ms");
//        }
//    }
    }
}