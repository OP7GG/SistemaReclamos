
package municipalidad.estructuras;
import municipalidad.modelo.Reclamo;

public class NodoBST {
    private Reclamo reclamo;
    private NodoBST izq;
    private NodoBST der;
    
    public NodoBST(Reclamo reclamo){
        this.reclamo = reclamo;
        izq = null;
        der = null;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public NodoBST getIzq() {
        return izq;
    }

    public NodoBST getDer() {
        return der;
    }

    public void setIzq(NodoBST izq) {
        this.izq = izq;
    }

    public void setDer(NodoBST der) {
        this.der = der;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }
    
}
