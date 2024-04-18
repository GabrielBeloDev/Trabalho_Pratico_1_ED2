package sort;

import java.util.Arrays;

public class DoubleHeapSort<T extends Comparable<T>> {
    private void buildMaxHeap(T[] heap, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(heap, i, size);
        }
    }

    private void buildMinHeap(T[] heap, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            minHeapify(heap, i, size);
        }
    }

    private T extractMax(T[] heap, int size) {
        T max = heap[0];
        heap[0] = heap[size - 1];
        maxHeapify(heap, 0, size - 1);
        return max;
    }

    private T extractMin(T[] heap, int size) {
        T min = heap[0];
        heap[0] = heap[size - 1];
        minHeapify(heap, 0, size - 1);
        return min;
    }

    private void maxHeapify(T[] heap, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < size && heap[left].compareTo(heap[largest]) > 0) {
            largest = left;
        }
        if (right < size && heap[right].compareTo(heap[largest]) > 0) {
            largest = right;
        }
        if (largest != i) {
            T swap = heap[i];
            heap[i] = heap[largest];
            heap[largest] = swap;
            maxHeapify(heap, largest, size);
        }
    }

    private void minHeapify(T[] heap, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < size && heap[left].compareTo(heap[smallest]) < 0) {
            smallest = left;
        }
        if (right < size && heap[right].compareTo(heap[smallest]) < 0) {
            smallest = right;
        }
        if (smallest != i) {
            T swap = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = swap;
            minHeapify(heap, smallest, size);
        }
    }
    public void doubleHeapSort(T[] array, boolean useThreads) {
        int n = array.length;
        T[] maxHeap = Arrays.copyOf(array, n);
        T[] minHeap = Arrays.copyOf(array, n);

        if (useThreads) {
            Thread threadMaxHeap = new Thread(() -> buildMaxHeap(maxHeap, n));
            Thread threadMinHeap = new Thread(() -> buildMinHeap(minHeap, n));
            threadMaxHeap.start();
            threadMinHeap.start();
            try {
                threadMaxHeap.join();
                threadMinHeap.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            buildMaxHeap(maxHeap, n);
            buildMinHeap(minHeap, n);
        }

        int left = 0;
        int right = n - 1;
        boolean useMax = false;

        while (left <= right) {
            if (useMax) {
                T max = extractMax(maxHeap, right - left + 1);
                array[right--] = max;
            } else {
                T min = extractMin(minHeap, right - left + 1);
                array[left++] = min;
            }
            useMax = !useMax;
        }
    }
}
