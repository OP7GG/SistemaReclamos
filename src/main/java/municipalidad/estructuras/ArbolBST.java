package municipalidad.estructuras;
import municipalidad.modelo.Reclamo;

public class ArbolBST {
    private NodoBST raiz;
    
    public ArbolBST(){
        raiz = null;
    }
    
    public void insertar(Reclamo reclamo){
        raiz = insertarRecursivo(raiz, reclamo);
    }
    
    private NodoBST insertarRecursivo(NodoBST nodo, Reclamo reclamo){
        if(nodo == null){
            return new NodoBST(reclamo);
        }
        if (reclamo.getCodigo() < nodo.getReclamo().getCodigo()){
            nodo.setIzq(insertarRecursivo(nodo.getIzq(), reclamo));
        }
        else if (reclamo.getCodigo() > nodo.getReclamo().getCodigo()){
            nodo.setDer(insertarRecursivo(nodo.getDer(), reclamo));
        }
        return nodo;
    }
    
    public Reclamo buscar(int codigo){
        NodoBST temp = raiz;
        
        while(temp != null){
            int codActual = temp.getReclamo().getCodigo();
            
            if(codigo == codActual){
                return temp.getReclamo();
            }
            
            if (codigo < codActual){
                temp = temp.getIzq();
            }
            else{
                temp = temp.getDer();
            }
        }
        return null;
    }
    
    public void inorden(){
        inordenRecursivo(raiz);
    }
    
    private void inordenRecursivo(NodoBST nodo){
        if(nodo != null){
            inordenRecursivo(nodo.getIzq());
            System.out.println(nodo.getReclamo());
            inordenRecursivo(nodo.getDer());
        }
    }
    
    public void preorden(){
        preordenRecursivo(raiz);
    }
    
    private void preordenRecursivo(NodoBST nodo){
        if(nodo != null){
            System.out.println(nodo.getReclamo());
            preordenRecursivo(nodo.getIzq());
            preordenRecursivo(nodo.getDer());
        }
    }
    
    public void posorden(){
        posordenRecursivo(raiz);
    }
    
    private void posordenRecursivo(NodoBST nodo){
        if(nodo != null){
            posordenRecursivo(nodo.getIzq());
            posordenRecursivo(nodo.getDer());
            System.out.println(nodo.getReclamo());
        }
    }
    
    public void eliminar(int codigo){
        raiz = eliminarRecursivo(raiz, codigo);
    }
    
    private NodoBST eliminarRecursivo(NodoBST nodo, int codigo){
        if(nodo == null){
            return null;
        }
        if(codigo < nodo.getReclamo().getCodigo()){
            nodo.setIzq(eliminarRecursivo(nodo.getIzq(), codigo));
        }
        else if(codigo > nodo.getReclamo().getCodigo()){
            nodo.setDer(eliminarRecursivo(nodo.getDer(), codigo));
        }
        else{
            if (nodo.getIzq() == null){
                return nodo.getDer();
            }
            if(nodo.getDer() == null){
                return nodo.getIzq();
            }
            NodoBST sucesor = obtenerMenor(nodo.getDer());
            nodo.setReclamo(sucesor.getReclamo());
            nodo.setDer(eliminarRecursivo(nodo.getDer(), sucesor.getReclamo().getCodigo()));
        }
        return nodo;
    }
    
    private NodoBST obtenerMenor(NodoBST nodo){
        while(nodo.getIzq() != null){
            nodo = nodo.getIzq();
        }
        return nodo;
    }
}