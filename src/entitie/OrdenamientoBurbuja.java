package entitie;

public class OrdenamientoBurbuja {
    public void ordenar(int[] array) {
        int n = array.length;//SE CREA LA VARIABLE N QUE CONTIENE EL TAMAÑO DEL ARREGLO
        boolean intercambio;//SE CREA UN BOOLEANO QUE INDICA SI SE INTERCAMBIO O NO
        for (int i = 0; i < n - 1; i++) {//SE GENERA UN ITERADOR CON VALOR MAXIMO EL TAMAÑO DEL ARREGLO
            intercambio = false;//SE ASIGNA FALSO A INTERCAMBIADO
            for (int j = 0; j < n - 1 - i; j++) {//SE GENERA UN SUB INTERADOR
                if (array[j] > array[j + 1]) {//SE VERIFICA SI EL ACTUAL ES MAYOR QUE EL SIGUIENTE
                    							//SI ES ASI
                    int temp = array[j]; 		//SE CREA UNA VARIABLE TEMPORAL Y SE LE ASIGNA A ELLA EL VALOR DEL VECTOR EN LA POS ACTUAL
                    array[j] = array[j + 1];	//SE ASIGNA EL VALOR SIGUIENTE A LA POS ACTUAL
                    array[j + 1] = temp;		//SE ASIGNA EN SIGUIENTE LA POS QUE ANTES ERA ACTUAL QUE ESTA ALMACENADA EN TEMPORAL
                    intercambio = true;			//SE INDICA QUE HUBO INTERCAMBIOS
                }
            }
            
            if (!intercambio) {//SI NO HUBO INTERCAMBIOS SIGNIFICA QUE ESTABA ORDENADO
                break;	
            }
        }
    }
}