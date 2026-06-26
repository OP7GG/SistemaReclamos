package municipalidad.estructuras;
import municipalidad.modelo.Reclamo;

public class NodoAVL {
    private Reclamo reclamo;
    private NodoAVL izq;
    private NodoAVL der;
    private int altura;
    
    public NodoAVL(Reclamo rec) {
        this.reclamo = rec;
        this.izq = null;
        this.der = null;
        altura = 1; 
    }

    public Reclamo getReclamo() { return reclamo; }
    public void setReclamo(Reclamo reclamo) { this.reclamo = reclamo; }
    
    public NodoAVL getIzq() { return izq; }
    public void setIzq(NodoAVL izq) { this.izq = izq; }
    
    public NodoAVL getDer() { return der; }
    public void setDer(NodoAVL der) { this.der = der; }
    
    public int getAltura() { return altura; }
    public void setAltura(int altura) { this.altura = altura; }
}