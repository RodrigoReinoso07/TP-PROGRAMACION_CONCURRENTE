package test;

import entitie.OrdenamientoBurbujaConcurrente;
import entitie.OrdenamientoBurbuja;

public class Test {
    public static void main(String[] args) {

        realizarPrueba(10);
        realizarPrueba(1000);
        realizarPrueba(10000);
        realizarPrueba(100000);
    }

    private static void realizarPrueba(int tamanio) {
        long start, end;

        System.out.println("ARREGLO DE " + tamanio + " ELEMENTOS:");
        int[] arreglo = OrdenamientoBurbujaConcurrente.generarArreglo(tamanio);
        int[] arregloC = arreglo.clone();

        if(tamanio == 10) {System.out.println("Vector Original:");
        OrdenamientoBurbujaConcurrente.imprimirArray(arreglo);}

        start = System.nanoTime();
        OrdenamientoBurbuja ob = new OrdenamientoBurbuja();
        ob.ordenar(arreglo);
        end = System.nanoTime() - start;
        System.out.println("EL ORDENAMIENTO DE ARREGLO DE " + tamanio + " ELEMENTOS SECUENCIAL DEMORO: " + end + "ns");
        if(tamanio == 10) {System.out.println("Vector Ordenado:");
        OrdenamientoBurbujaConcurrente.imprimirArray(arreglo);}

        start = System.nanoTime();
        OrdenamientoBurbujaConcurrente.ordenarConcurrentemente(arregloC);
        end = System.nanoTime() - start;
        System.out.println("EL ORDENAMIENTO DE ARREGLO DE " + tamanio + " ELEMENTOS CONCURRENTE DEMORO: " + end + "ns");
        if(tamanio == 10) {System.out.println("Vector Ordenado:");
        OrdenamientoBurbujaConcurrente.imprimirArray(arregloC);}

        System.out.println("\n\n");
    }
}
