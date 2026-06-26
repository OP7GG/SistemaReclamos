package municipalidad.servicios;

import municipalidad.modelo.Reclamo;
import municipalidad.estructuras.*;
import municipalidad.algoritmos.*;

public class SistemaReclamos {
    
    private ListaReclamos lista;
    private ColaReclamos cola;
    private PilaReclamos historial;
    private ArbolBST arbolBST;
    private ArbolAVL arbolAVL;
    private int contador;
    
    public SistemaReclamos() {
        lista = new ListaReclamos();
        cola = new ColaReclamos();
        historial = new PilaReclamos();
        arbolBST = new ArbolBST();
        arbolAVL = new ArbolAVL();
        contador = 1;
    }
    
    public Reclamo registrarReclamo(String nombre, String rut, String tipo, 
                                     String descripcion, int prioridad, int diasVencimiento) {
        int codigo = contador++;
        Reclamo reclamo = new Reclamo(codigo, nombre, rut, tipo, descripcion, prioridad, 
                                      "Por asignar", diasVencimiento);
        
        lista.agregar(reclamo);
        arbolBST.insertar(reclamo);
        arbolAVL.insertar(reclamo);
        cola.encolar(reclamo);
        historial.push("Reclamo " + codigo + " registrado por " + nombre);
        
        System.out.println("Reclamo registrado: " + reclamo);
        return reclamo;
    }
    
    public boolean eliminarReclamo(String codigo) {
        try {
            int codigoInt = Integer.parseInt(codigo);
            Reclamo reclamo = lista.buscar(codigoInt);
            if (reclamo == null) {
                System.out.println("Reclamo no encontrado");
                return false;
            }
            
            lista.eliminar(codigoInt);
            historial.push("Reclamo " + codigo + " eliminado");
            System.out.println("Reclamo eliminado");
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Codigo invalido");
            return false;
        }
    }
    
    public void buscarPorCodigo(String codigo) {
        try {
            int codigoInt = Integer.parseInt(codigo);
            Reclamo reclamo = arbolBST.buscar(codigoInt);
            if (reclamo != null) {
                System.out.println("Encontrado: " + reclamo);
            } else {
                System.out.println("No encontrado");
            }
        } catch (NumberFormatException e) {
            System.out.println("Codigo invalido");
        }
    }
    
    public void buscarPorRut(String rut) {
        Reclamo[] arr = lista.toArray();
        Reclamo reclamo = Busqueda.buscarPorRut(arr, rut);
        if (reclamo != null) {
            System.out.println("Encontrado: " + reclamo);
        } else {
            System.out.println("No encontrado");
        }
    }
    
    public void cambiarEstado(String codigo, String nuevoEstado) {
        try {
            int codigoInt = Integer.parseInt(codigo);
            Reclamo reclamo = lista.buscar(codigoInt);
            if (reclamo != null) {
                reclamo.setEstado(nuevoEstado);
                historial.push("Estado de " + codigo + " cambio a " + nuevoEstado);
                System.out.println("Estado actualizado");
            } else {
                System.out.println("Reclamo no encontrado");
            }
        } catch (NumberFormatException e) {
            System.out.println("Codigo invalido");
        }
    }
    
    public void atenderSiguiente() {
        Reclamo reclamo = cola.desencolar();
        if (reclamo != null) {
            reclamo.setEstado("EN_PROCESO");
            System.out.println("Atendiendo: " + reclamo);
        } else {
            System.out.println("No hay reclamos en la cola");
        }
    }
    
    public void mostrarTodos() {
        lista.mostrar();
    }
    
    public void mostrarInorden() {
        System.out.println("Recorrido Inorden BST");
        arbolBST.inorden();
    }
    
    public void mostrarPreorden() {
        System.out.println("Recorrido Preorden BST");
        arbolBST.preorden();
    }
    
    public void mostrarPostorden() {
        System.out.println("Recorrido Postorden BST");
        arbolBST.posorden();
    }
    
    public void mostrarAVLInorden() {
        System.out.println("Recorrido Inorden Arbol AVL (balanceado)");
        arbolAVL.inorden();
    }
    
    public void ordenarPorPrioridad() {
        Reclamo[] arr = lista.toArray();
        Ordenamiento.bubbleSort(arr);
        System.out.println("Ordenado por prioridad Bubble Sort");
        for (Reclamo r : arr) {
            System.out.println(r);
        }
    }
    
    public void ordenarConMergeSort() {
        Reclamo[] arr = lista.toArray();
        Ordenamiento.mergeSort(arr);
        System.out.println("Ordenado con Merge Sort");
        for (Reclamo r : arr) {
            System.out.println(r);
        }
    }
    
    public void alertasVencimiento() {
        Reclamo[] arr = lista.toArray();
        System.out.println("Reclamos proximos a vencer");
        boolean hay = false;
        for (Reclamo r : arr) {
            if (r.estaProximoAVencer()) {
                System.out.println("ALERTA: " + r);
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay reclamos proximos a vencer");
        }
    }
    
    public void mostrarHistorial() {
        historial.mostrarHistorial();
    }
    
    public void estadisticas() {
        System.out.println("Estadisticas");
        System.out.println("Total de reclamos: " + lista.getTamaño());
        System.out.println("Reclamos en cola: " + cola.getTamaño());
        System.out.println("Cambios registrados: " + historial.getTamaño());
    }
}