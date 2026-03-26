import java.util.Scanner; // Para leer entrada

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Entrada usuario
        Historial historial = new Historial(); // Crear historial

        String comando; // Variable para comandos

        System.out.println("Editor de texto (:u undo, :r redo, :q salir)");

        while (true) {

            System.out.print("> "); // Prompt
            comando = sc.nextLine(); // Leer entrada

            if (comando.equals(":q")) {
                break; // Salir
            } else if (comando.equals(":u")) {
                historial.undo(); // Deshacer
            } else if (comando.equals(":r")) {
                historial.redo(); // Rehacer
            } else {
                historial.agregarEstado(comando); // Guardar texto
            }

            historial.mostrarActual(); // Mostrar estado
        }

        sc.close(); // Cerrar scanner
    }
}