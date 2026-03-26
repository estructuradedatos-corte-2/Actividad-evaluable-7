public class NodoDoble {

    private EstadoDocumento estado;
    private NodoDoble siguiente;
    private NodoDoble anterior;

    public NodoDoble(EstadoDocumento estado) {
        this.estado = estado;
        this.siguiente = null;
        this.anterior = null;
    }

    public EstadoDocumento getEstado() {
        return estado;
    }

    public void setEstado(EstadoDocumento estado) {
        this.estado = estado;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}