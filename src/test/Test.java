package test;

import java.util.Arrays;
import java.util.Random;

import entitie.OrdenamientoBurbuja;
import entitie.OrdenamientoBurbujaConcurrente;

public class Test {
    public static void main(String[] args) {
    	long start, end;
    	int longitudParte;
    	int numHilos = Runtime.getRuntime().availableProcessors();
    	if(numHilos>10) numHilos = 10;
        //int longitudParte = array.length / numHilos;
    	
        OrdenamientoBurbujaConcurrente[] hilos = new OrdenamientoBurbujaConcurrente[numHilos];//GENERA VECTOR DE HILOS
        OrdenamientoBurbuja ob = new OrdenamientoBurbuja();//GENERA INSTANCIA DE CLASE ORDENAMIENTO BURBUJA
        
        
        
        System.out.println("ARREGLO DE 10 ELEMENTOS:");
        
        int arreglo1[] = generarArreglo(10);//GENERA ARREGLO DE 10 ELEMENTOS
        
        
        start = System.nanoTime();//CAPTURA TIEMPO INICIO
        ob.ordenar(arreglo1);//LLAMA AL ORDENAMIENTO SECUENCIAL
        end = System.nanoTime() - start;//CAPTURA TIEMPO FINAL
        
        System.out.println("EL ORDENAMIENTO DE ARREGLO DE 10 ELEMENTOS SECUENCIAL DEMORO: " + end + "ns");
        
        longitudParte = arreglo1.length / numHilos;//ASIGNA LA CANTIDAD QUE CONTEMPLA CADA HILO
        start = System.nanoTime();//CAPTURA TIEMPO INICIO
        for (int i = 0; i < numHilos; i++) {
            int inicio = i * longitudParte;//ASIGNA INCIO CONTEMPLADO
            int fin = (i == numHilos - 1) ? arreglo1.length - 1 : (inicio + longitudParte - 1);//ASIGNA FIN CONTEMPLADO
            hilos[i] = new OrdenamientoBurbujaConcurrente(arreglo1, inicio, fin);//LLAMA AL ORDENAMIENTO
            hilos[i].start();//LANZA EL HILO
        }
        try {
            for (OrdenamientoBurbujaConcurrente hilo : hilos) {
                hilo.join();//ESPERA QUE LOS HILOS FINALICEN
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Arrays.sort(arreglo1);
        
        end = System.nanoTime() - start;//CAPTURA TIEMPO FINAL
        
        System.out.println("EL ORDENAMIENTO DE ARREGLO DE 10 CONCURRENTE ELEMENTOS DEMORO: " + end + "ns");
        
        
        //
        System.out.println("\n\n");
        //
        
        
        System.out.println("ARREGLO DE 1.000 ELEMENTOS:");
        
        int arreglo2[] = generarArreglo(1000);//GENERA ARREGLO DE 1000 ELEMENTOS
        
        
        start = System.nanoTime();//CAPTURA TIEMPO INICIO
        ob.ordenar(arreglo2);//LLAMA AL ORDENAMIENTO SECUENCIAL
        end = System.nanoTime() - start;//CAPTURA TIEMPO FINAL
        
        System.out.println("EL ORDENAMIENTO DE ARREGLO DE 1.000 ELEMENTOS SECUENCIAL DEMORO: " + end + "ns");
        
        longitudParte = arreglo2.length / numHilos;//ASIGNA LA CANTIDAD QUE CONTEMPLA CADA HILO
        start = System.nanoTime();// CAPTURA TIEMPO INICIO
        for (int i = 0; i < numHilos; i++) {
            int inicio = i * longitudParte;//ASIGNA INCIO CONTEMPLADO
            int fin = (i == numHilos - 1) ? arreglo1.length - 1 : (inicio + longitudParte - 1);//ASIGNA FIN CONTEMPLADO
            hilos[i] = new OrdenamientoBurbujaConcurrente(arreglo2, inicio, fin);//LLAMA AL ORDENAMIENTO
            hilos[i].start();//LANZA EL HILO
        }
        try {
            for (OrdenamientoBurbujaConcurrente hilo : hilos) {
                hilo.join();//ESPERA QUE LOS HILOS FINALICEN
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Arrays.sort(arreglo2);
        end = System.nanoTime() - start;//CAPTURA TIEMPO FINAL
        
        System.out.println("EL ORDENAMIENTO DE ARREGLO DE 1.000 CONCURRENTE ELEMENTOS DEMORO: " + end + "ns");

        
        //
        System.out.println("\n\n");
        //
        
        
        System.out.println("ARREGLO DE 10.000 ELEMENTOS:");
        
        int arreglo3[] = generarArreglo(10000);//GENERA ARREGLO DE 10000 ELEMENTOS
        
        
        start = System.nanoTime();//CAPTURA TIEMPO INICIO
        ob.ordenar(arreglo3);//LLAMA AL ORDENAMIENTO SECUENCIAL
        end = System.nanoTime() - start;//CAPTURA TIEMPO FINAL
        
        System.out.println("EL ORDENAMIENTO DE ARREGLO DE 10.000 ELEMENTOS SECUENCIAL DEMORO: " + end + "ns");
        
        longitudParte = arreglo3.length / numHilos;//ASIGNA LA CANTIDAD QUE CONTEMPLA CADA HILO
        start = System.nanoTime();//CAPTURA TIEMPO INICIO
        for (int i = 0; i < numHilos; i++) {
            int inicio = i * longitudParte;//ASIGNA INCIO CONTEMPLADO
            int fin = (i == numHilos - 1) ? arreglo3.length - 1 : (inicio + longitudParte - 1);//ASIGNA FIN CONTEMPLADO
            hilos[i] = new OrdenamientoBurbujaConcurrente(arreglo3, inicio, fin);//LLAMA AL ORDENAMIENTO
            hilos[i].start();//LANZA EL HILO
        }
        try {
            for (OrdenamientoBurbujaConcurrente hilo : hilos) {
                hilo.join();//ESPERA QUE LOS HILOS FINALICEN
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Arrays.sort(arreglo3);
        end = System.nanoTime() - start;
        
        System.out.println("EL ORDENAMIENTO DE ARREGLO DE 10.000 CONCURRENTE ELEMENTOS DEMORO: " + end + "ns");

        
        //
        System.out.println("\n\n");
        //
        
        
        System.out.println("ARREGLO DE 100.000 ELEMENTOS:");
        
        int arreglo4[] = generarArreglo(100000);//GENERA ARREGLO DE 100000 ELEMENTOS
        
        
        start = System.nanoTime();//CAPTURA TIEMPO INICIO
        ob.ordenar(arreglo4);//LLAMA AL ORDENAMIENTO SECUENCIAL
        end = System.nanoTime() - start;//CAPTURA TIEMPO FINAL
        
        System.out.println("EL ORDENAMIENTO DE ARREGLO DE 100.000 ELEMENTOS SECUENCIAL DEMORO: " + end + "ns");
        
        longitudParte = arreglo4.length / numHilos;//ASIGNA LA CANTIDAD QUE CONTEMPLA CADA HILO
        start = System.nanoTime();
        for (int i = 0; i < numHilos; i++) {
            int inicio = i * longitudParte;//ASIGNA INCIO CONTEMPLADO
            int fin = (i == numHilos - 1) ? arreglo4.length - 1 : (inicio + longitudParte - 1);//ASIGNA FIN CONTEMPLADO
            hilos[i] = new OrdenamientoBurbujaConcurrente(arreglo4, inicio, fin);//LLAMA AL ORDENAMIENTO
            hilos[i].start();//LANZA EL HILO
        }
        try {
            for (OrdenamientoBurbujaConcurrente hilo : hilos) {
                hilo.join();//ESPERA QUE LOS HILOS FINALICEN
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Arrays.sort(arreglo4);
        end = System.nanoTime() - start;//CAPTURA TIEMPO FINAL
        
        System.out.println("EL ORDENAMIENTO DE ARREGLO DE 100.000 CONCURRENTE ELEMENTOS DEMORO: " + end + "ns");
        
        
        
        
        
        
        
    }
    
    
    private static int[] generarArreglo(int tamanio) {
		
		Random rand = new Random(System.nanoTime());
		int arreglo[] = new int[tamanio];
		
		
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = rand.nextInt(1,10000);
		}
		
		return arreglo;
		
	}

}