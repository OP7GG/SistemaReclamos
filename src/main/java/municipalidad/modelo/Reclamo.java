package municipalidad.modelo;

public class Reclamo {
    
    private int codigo;
    private String nombre;
    private String rut;
    private String tipo;
    private String descripcion;
    private String fechaIngreso; 
    private String estado;
    private int prioridad;
    private String fechaVencimiento; 
    private int diasParaVencer; 
    
    public Reclamo(int codigo, String nombre, String rut, String tipo, 
                   String descripcion, int prioridad, String fechaVencimiento, int diasParaVencer) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.rut = rut;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaIngreso = "20/06/2024"; 
        this.estado = "PENDIENTE";
        this.prioridad = prioridad;
        this.fechaVencimiento = fechaVencimiento;
        this.diasParaVencer = diasParaVencer;
    }
    
    public String getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public String getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(String fechaIngreso) { this.fechaIngreso = fechaIngreso; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public int getPrioridad() { return prioridad; }
    public void setPrioridad(int prioridad) { this.prioridad = prioridad; }
    
    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    
    public int getDiasParaVencer() { return diasParaVencer; }
    public void setDiasParaVencer(int diasParaVencer) { this.diasParaVencer = diasParaVencer; }
    
    public boolean estaProximoAVencer() {
        return this.diasParaVencer <= 3 && this.diasParaVencer > 0;
    }
    
    @Override
    public String toString() {
        return "[" + codigo + "] " + nombre + " - " + tipo + " (Prioridad: " + prioridad + ") - " + estado + " (Vence en: " + diasParaVencer + " días)";
    }
}
