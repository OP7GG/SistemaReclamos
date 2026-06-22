package municipalidad.estructuras;

public class PilaReclamos {
    
    private Nodo cima;
    private int tamaño;
    
    private class Nodo {
        String historialCambio; 
        Nodo siguiente;
        
        Nodo(String historialCambio) {
            this.historialCambio = historialCambio;
            this.siguiente = null;
        }
    }
    
    public PilaReclamos() {
        cima = null;
        tamaño = 0;
    }
    
    public void push(String cambio) {
        Nodo nuevo = new Nodo(cambio);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamaño++;
    }
    
    public String pop() {
        if (estaVacia()) {
            return null;
        }
        String aux = cima.historialCambio;
        cima = cima.siguiente;
        tamaño--;
        return aux;
    }
    
    public boolean estaVacia() {
        return cima == null;
    }
    
    public int getTamaño() {
        return tamaño;
    }
    
    public void mostrarHistorial() {
        System.out.println("Historial de cambios");
        Nodo actual = cima;
        while (actual != null) {
            System.out.println("- " + actual.historialCambio);
            actual = actual.siguiente;
        }
    }
}