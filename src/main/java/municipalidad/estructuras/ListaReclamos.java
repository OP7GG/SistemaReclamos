package municipalidad.estructuras;

import municipalidad.modelo.Reclamo;

public class ListaReclamos {
    
    private Nodo cabeza;
    private int tamaño;
    
    private class Nodo {
        Reclamo dato;
        Nodo siguiente;
        Nodo(Reclamo dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    
    public ListaReclamos() {
        cabeza = null;
        tamaño = 0;
    }
    
    public void agregar(Reclamo reclamo) {
        Nodo nuevo = new Nodo(reclamo);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamaño++;
    }
    
    public boolean eliminar(int codigo) {
        if (cabeza == null) {
            return false;
        }
        
        if (cabeza.dato.getCodigo()== codigo) {
            cabeza = cabeza.siguiente;
            tamaño--;
            return true;
        }
        
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato.getCodigo()== codigo ) {
                actual.siguiente = actual.siguiente.siguiente;
                tamaño--;
                return true;
            }
            actual = actual.siguiente;
        }
        
        return false;
    }
    
    public Reclamo buscar(int codigo) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato.getCodigo() == codigo) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }
    
    public Reclamo[] toArray() {
        Reclamo[] arr = new Reclamo[tamaño];
        Nodo actual = cabeza;
        int i = 0;
        
        while (actual != null) {
            arr[i] = actual.dato;
            actual = actual.siguiente;
            i++;
        }
        
        return arr;
    }
    
    public int getTamaño() {
        return tamaño;
    }
    
    public void mostrar() {
        Nodo actual = cabeza;
        System.out.println("Todos los reclamos");
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}
