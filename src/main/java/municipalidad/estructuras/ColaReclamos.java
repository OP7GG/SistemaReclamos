package municipalidad.estructuras;

import municipalidad.modelo.Reclamo;

public class ColaReclamos {
    
    private Nodo frente;
    private Nodo fin;
    private int tamaño;
    
    private class Nodo {
        Reclamo dato;
        Nodo siguiente;
        
        Nodo(Reclamo dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    
    public ColaReclamos() {
        frente = null;
        fin = null;
        tamaño = 0;
    }
    
    public void encolar(Reclamo reclamo) {
        Nodo nuevo = new Nodo(reclamo);
        if (estaVacia()) {
            frente = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        tamaño++;
    }
    
    public Reclamo desencolar() {
        if (estaVacia()) {
            return null;
        }
        Reclamo aux = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        tamaño--;
        return aux;
    }
    
    public boolean estaVacia() {
        return frente == null;
    }
    
    public int getTamaño() {
        return tamaño;
    }
}