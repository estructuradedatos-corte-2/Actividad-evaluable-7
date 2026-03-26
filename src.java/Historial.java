public class Historial {

    private NodoDoble cabeza; // Primer nodo
    private NodoDoble cola;   // Último nodo
    private NodoDoble actual; // Estado actual

    // Constructor
    public Historial() {
        this.cabeza = null; // Lista vacía
        this.cola = null;
        this.actual = null;
    }

    // Agregar nuevo estado (🔥 incluye truncamiento)
    public void agregarEstado(String texto) {

        EstadoDocumento estado = new EstadoDocumento(texto); // Crear estado
        NodoDoble nuevo = new NodoDoble(estado); // Crear nodo

        // Si la lista está vacía
        if (cabeza == null) {
            cabeza = nuevo; // Primer nodo
            cola = nuevo;   // También es el último
            actual = nuevo; // Estado actual
            return;
        }

        //  TRUNCAMIENTO (clave del taller)
        if (actual.getSiguiente() != null) {
            NodoDoble temp = actual.getSiguiente(); // Nodo a eliminar

            while (temp != null) {
                NodoDoble siguiente = temp.getSiguiente(); // Guardar siguiente
                temp.setAnterior(null); // Romper enlace atrás
                temp.setSiguiente(null); // Romper enlace adelante
                temp = siguiente; // Avanzar
            }

            actual.setSiguiente(null); // Cortar la lista
            cola = actual; // Nuevo final
        }

        // Insertar después del actual
        actual.setSiguiente(nuevo); // Actual apunta al nuevo
        nuevo.setAnterior(actual);  // Nuevo apunta atrás
        cola = nuevo;               // Nuevo es el último
        actual = nuevo;             // Nuevo estado actual
    }

    // Deshacer (undo)
    public void undo() {
        if (actual != null && actual.getAnterior() != null) {
            actual = actual.getAnterior(); // Ir al estado anterior
        } else {
            System.out.println("No se puede deshacer"); // Límite
        }
    }

    // Rehacer (redo)
    public void redo() {
        if (actual != null && actual.getSiguiente() != null) {
            actual = actual.getSiguiente(); // Ir al siguiente estado
        } else {
            System.out.println("No se puede rehacer"); // Límite
        }
    }

    // Mostrar estado actual
    public void mostrarActual() {
        if (actual != null) {
            System.out.println("Texto actual: " + actual.getEstado().getContenido());
        }
    }
}