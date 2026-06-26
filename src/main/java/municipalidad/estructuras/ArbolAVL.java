package municipalidad.estructuras;
import municipalidad.modelo.Reclamo;

public class ArbolAVL {
    private NodoAVL raiz;
    
    public ArbolAVL() {
        raiz = null;
    }
    
    public void insertar(Reclamo rec) {
        raiz = insertarRec(raiz, rec);
    }
    
    private NodoAVL insertarRec(NodoAVL actual, Reclamo rec) {
        if (actual == null) {
            return new NodoAVL(rec);
        }
        
        if (rec.getCodigo() < actual.getReclamo().getCodigo()) {
            actual.setIzq(insertarRec(actual.getIzq(), rec));
        } else if (rec.getCodigo() > actual.getReclamo().getCodigo()) {
            actual.setDer(insertarRec(actual.getDer(), rec));
        }
        
        return balancear(actual);
    }
    
    private NodoAVL balancear(NodoAVL nodo) {
        actualizarAlt(nodo);
        int balance = getBalance(nodo);
        
        if (balance > 1 && getBalance(nodo.getIzq()) >= 0) {
            return rotacionDer(nodo);
        }
        
        if (balance < -1 && getBalance(nodo.getDer()) <= 0) {
            return rotacionIzq(nodo);
        }
        
        if (balance > 1 && getBalance(nodo.getIzq()) < 0) {
            nodo.setIzq(rotacionIzq(nodo.getIzq()));
            return rotacionDer(nodo);
        }
        
        if (balance < -1 && getBalance(nodo.getDer()) > 0) {
            nodo.setDer(rotacionDer(nodo.getDer()));
            return rotacionIzq(nodo);
        }
        
        return nodo;
    }
    
    private NodoAVL rotacionDer(NodoAVL n) {
        NodoAVL aux = n.getIzq();
        n.setIzq(aux.getDer());
        aux.setDer(n);
        
        actualizarAlt(n);
        actualizarAlt(aux);
        
        return aux;
    }
    
    private NodoAVL rotacionIzq(NodoAVL n) {
        NodoAVL aux = n.getDer();
        n.setDer(aux.getIzq());
        aux.setIzq(n);
        
        actualizarAlt(n);
        actualizarAlt(aux);
        
        return aux;
    }
    
    private int altura(NodoAVL n) {
        if (n == null) return 0;
        return n.getAltura();
    }
    
    private void actualizarAlt(NodoAVL n) {
        if (n != null) {
            int altIzq = altura(n.getIzq());
            int altDer = altura(n.getDer());
            n.setAltura(1 + Math.max(altIzq, altDer));
        }
    }
    
    private int getBalance(NodoAVL n) {
        if (n == null) return 0;
        return altura(n.getIzq()) - altura(n.getDer());
    }
    
    public Reclamo buscar(int cod) {
        NodoAVL aux = raiz;
        
        while (aux != null) {
            int codActual = aux.getReclamo().getCodigo();
            
            if (cod == codActual) return aux.getReclamo();
            
            if (cod < codActual) {
                aux = aux.getIzq();
            } else {
                aux = aux.getDer();
            }
        }
        return null;
    }
    
    public void inorden() {
        recorrerInorden(raiz);
    }
    
    private void recorrerInorden(NodoAVL n) {
        if (n != null) {
            recorrerInorden(n.getIzq());
            System.out.println(n.getReclamo());
            recorrerInorden(n.getDer());
        }
    }
}