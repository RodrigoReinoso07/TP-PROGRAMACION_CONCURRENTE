package entitie;

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
    public void run() {//FUNCION QUE SE EJECUTA AL LANZAR UN HILO
    	for (int i = inicio; i < fin; i++) {//VECTOR QUE COMIENTZA EN EL INICIO CONTEMPLADO Y EL FINALIZA EN EL FIN CONTEMPLADO
            for (int j = inicio; j < fin - (i - inicio); j++) {//SUB VECTOR CONTEMPLADO EN LOS MISMOS VALORES QUE HACE QUE TODO SE EJECUTE AL CUADRADO
                if (array[j] > array[j + 1]) {//VERIFICA SI EL VALOR J ES MAYOR AL VALOR SIGUIENTE, EN CASO DE SER ASI
                    int temp = array[j];//SE CREA UN TEMPORAL PARA NO PERDER DATO Y SE LE ASIGNA EL VALOR ACTUAL DEL VECTOR
                    array[j] = array[j + 1];//ASIGNA EL VALOR SIGUIENTE EN LA POS ACTUAL
                    array[j + 1] = temp;//MUEVE EL VALOR TEMPORAL AL VALOR SIGUIENTE
                }
            }
        }
    }
    
}

