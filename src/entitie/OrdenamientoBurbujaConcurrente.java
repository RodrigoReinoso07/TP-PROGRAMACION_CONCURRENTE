package entitie;

import java.util.Random;

public class OrdenamientoBurbujaConcurrente extends Thread {
    private final int[] array;
    private final int inicio;
    private final int fin;

    public OrdenamientoBurbujaConcurrente(int[] array, int inicio, int fin) {
        this.array = array;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        ordenarBurbuja(array, inicio, fin);
    }

    private void ordenarBurbuja(int[] array, int inicio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            for (int j = inicio; j <= fin - 1 - (i - inicio); j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void ordenarConcurrentemente(int[] array) {
        int numHilos = Runtime.getRuntime().availableProcessors();
        if (numHilos > 10) numHilos = 10;
        int longitudParte = array.length / numHilos;
        OrdenamientoBurbujaConcurrente[] hilos = new OrdenamientoBurbujaConcurrente[numHilos];

        for (int i = 0; i < numHilos; i++) {
            int inicio = i * longitudParte;
            int fin = (i == numHilos - 1) ? array.length - 1 : (inicio + longitudParte - 1);
            hilos[i] = new OrdenamientoBurbujaConcurrente(array, inicio, fin);
            hilos[i].start();
        }

        try {
            for (OrdenamientoBurbujaConcurrente hilo : hilos) {
                hilo.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        combinarPartes(array, numHilos, longitudParte);
    }

    private static void combinarPartes(int[] array, int numHilos, int longitudParte) {
        int[] resultado = new int[array.length];
        int[] indices = new int[numHilos];

        for (int i = 0; i < numHilos; i++) {
            indices[i] = i * longitudParte;
        }

        for (int i = 0; i < array.length; i++) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;

            for (int j = 0; j < numHilos; j++) {
                if (indices[j] < ((j + 1) * longitudParte) && indices[j] < array.length && array[indices[j]] < minValue) {
                    minValue = array[indices[j]];
                    minIndex = j;
                }
            }

            resultado[i] = minValue;
            indices[minIndex]++;
        }

        System.arraycopy(resultado, 0, array, 0, array.length);
    }

    public static int[] generarArreglo(int tamanio) {
        Random rand = new Random(System.nanoTime());
        int[] arreglo = new int[tamanio];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = rand.nextInt(10000);
        }
        return arreglo;
    }

    public static void imprimirArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
