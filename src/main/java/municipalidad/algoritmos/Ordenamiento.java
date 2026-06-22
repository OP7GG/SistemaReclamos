package municipalidad.algoritmos;

import municipalidad.modelo.Reclamo;

public class Ordenamiento {
    
    public static void bubbleSort(Reclamo[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                if (arr[j].getPrioridad() > arr[j + 1].getPrioridad()) {
                    Reclamo temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    public static void mergeSort(Reclamo[] arr) {
        if (arr.length <= 1) {
            return;
        }
        
        mergeSortRec(arr, 0, arr.length - 1);
    }
    
    private static void mergeSortRec(Reclamo[] arr, int izq, int der) {
        if (izq < der) {
            int medio = (izq + der) / 2;
            
            
            mergeSortRec(arr, izq, medio);
            
            mergeSortRec(arr, medio + 1, der);
            
            
            fusionar(arr, izq, medio, der);
        }
    }
    
    private static void fusionar(Reclamo[] arr, int izq, int medio, int der) {
        int n1 = medio - izq + 1;
        int n2 = der - medio;
        
        Reclamo[] izqArr = new Reclamo[n1];
        Reclamo[] derArr = new Reclamo[n2];
        
        
        for (int i = 0; i < n1; i++) {
            izqArr[i] = arr[izq + i];
        }
        
        for (int i = 0; i < n2; i++) {
            derArr[i] = arr[medio + 1 + i];
        }
        
        int i = 0;
        int j = 0;
        int k = izq;
        
        
        while (i < n1 && j < n2) {
            if (izqArr[i].getPrioridad() <= derArr[j].getPrioridad()) {
                arr[k] = izqArr[i];
                i++;
            } else {
                arr[k] = derArr[j];
                j++;
            }
            k++;
        }
        
        
        while (i < n1) {
            arr[k] = izqArr[i];
            i++;
            k++;
        }
        
        
        while (j < n2) {
            arr[k] = derArr[j];
            j++;
            k++;
        }
    }
    
    public static void ordenarPorVencimiento(Reclamo[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].getDiasParaVencer() > arr[j + 1].getDiasParaVencer()) {
                    Reclamo temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}