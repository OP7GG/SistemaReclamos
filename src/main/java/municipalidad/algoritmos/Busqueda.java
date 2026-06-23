package municipalidad.algoritmos;

import municipalidad.modelo.Reclamo;

public class Busqueda {
    
    public static Reclamo busquedaSecuencial(Reclamo[] arr, int codigo) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].getCodigo() == codigo) {
                return arr[i];
            }
        }
        return null;
    }
    
    public static Reclamo busquedaBinaria(Reclamo[] arr, int codigo) {
        return busquedaBinariaRec(arr, codigo, 0, arr.length - 1);
    }
    
    private static Reclamo busquedaBinariaRec(Reclamo[] arr, int codigo, int izq, int der) {
        if (izq > der) {
            return null;
        }
        
        int medio = izq + (der - izq) / 2;
        
        if (arr[medio].getCodigo() == codigo) {
            return arr[medio];
        }
        
        if (codigo < arr[medio].getCodigo()) {
            return busquedaBinariaRec(arr, codigo, izq, medio - 1);
        } else {
            return busquedaBinariaRec(arr, codigo, medio + 1, der);
        }
    }
    
    public static Reclamo buscarPorRut(Reclamo[] arr, String rut) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].getRut().equals(rut)) {
                return arr[i];
            }
        }
        return null;
    }
}