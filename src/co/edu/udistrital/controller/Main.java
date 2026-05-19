package co.edu.udistrital.controller;


import co.edu.udistrital.controller.TaskController;
import co.edu.udistrital.view.ConsoleView;

/**
 * Clase principal que sirve como punto de entrada (entry point) para la ejecución
 * de la aplicación de asignación y planificación de tareas.
 * Se encarga de inicializar el controlador central y la interfaz de usuario por consola.
 *
 * @author Chrz
 */
public class Main {

    /**
     * Método principal que arranca la aplicación.
     * Construye los componentes base siguiendo el patrón de diseño MVC
     * e inicia el bucle del menú interactivo de la interfaz.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args){
        TaskController controller= new TaskController();
        ConsoleView view = new ConsoleView(controller);
        view.startMenu();
    }
}