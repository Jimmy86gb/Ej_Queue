package co.edu.udistrital.view;

import co.edu.udistrital.controller.TaskController;
import java.util.Scanner;

/**
 * Clase que gestiona la Interfaz de Usuario a través de la consola estándar.
 * Captura las interacciones y despliega los menús operativos del sistema de asignación.
 *
 * @author Chrz
 */
public class ConsoleView {
    private TaskController controller;
    private Scanner sc;
    private InputHelper ih;
    
    /**
     * Inicializa la interfaz de consola acoplándola con su controlador maestro.
     *
     * @param controller Instancia del controlador lógico que dirigirá el flujo de negocio.
     */
    public ConsoleView(TaskController controller) {
        this.controller = controller;
        this.sc = new Scanner(System.in);
        this.ih = new InputHelper();
    }

    /**
     * Despliega en bucle continuo el menú principal de opciones en la consola,
     * redireccionando a los métodos ejecutores hasta solicitar la salida.
     */
    public void startMenu() {
        int option = 0;
        while (option != 5) {
            System.out.println("----Menu de Asignacion de Tareas----");
            System.out.println("1. Añadir Tarea");
            System.out.println("2. Eliminar Tarea");
            System.out.println("3. Mostrar Tareas");
            System.out.println("4. Procesar Tareas");
            System.out.println("5. Salir");
            option = ih.requestPositiveInteger(sc, 1, 5, "Elija una opcion: ");
            switch (option) {
                case 1:
                    ExecuteAddTask();
                    break;
                case 2:
                    ExecuteRemoveTask();
                    break;
                case 3:
                    ExecuteShowTasks();
                    break;
                case 4:
                    ExecuteScheduling();
                    break;
                case 5:
                    break;
            }
        }    
    }

    /**
     * Ejecuta el flujo para la captura por teclado de una nueva tarea, invocando
     * los servicios de creación del controlador.
     */
    public void ExecuteAddTask() {
        System.out.println("Ingrese el nombre de la tarea");
        String name = sc.nextLine();
        double time = ih.requestPositiveDouble(sc, 0, Double.MAX_VALUE, "Ingrese el tiempo de realizacion de la tarea (en minutos): ");
        if (controller.createTask(time, name)) {
            System.out.println("Tarea agregada con exito");
        } else {
            System.out.println("Error, tarea con ese nombre ya existe");
        }
    }

    /**
     * Ejecuta el flujo interactivo de eliminación de tareas por pantalla. Reintenta 
     * de forma iterativa el proceso hasta introducir un identificador existente.
     */
    public void ExecuteRemoveTask() {
        String name;
        boolean success;
        if (controller.taskListIsEmpty()) {
            System.out.println("No hay tareas");
        } else {
            do {
                System.out.println("Escriba el nombre de la tarea que desea eliminar");
                System.out.println(controller.getTasksAsText());
                name = sc.nextLine();
                success = controller.deleteTask(name);
                if (!success) {
                    System.out.println("Tarea no encontrada");
                }
            } while (!success);
            System.out.println("La tarea ha sido eliminada con exito");
        }
    }
    
    /**
     * Muestra en pantalla el bloque de texto consolidado de todas las tareas registradas.
     */
    public void ExecuteShowTasks() {
        System.out.println(controller.getTasksAsText());
    }

    /**
     * Despega la solicitud del total de procesadores para simular el agendamiento greedy, 
     * imprimiendo los resultados calculados y su respectivo tiempo medio optimizado.
     */
    public void ExecuteScheduling() {
        if (controller.taskListIsEmpty()) {
            System.out.println("No hay tareas");
        } else {
            int numProcessors = ih.requestPositiveInteger(sc, 1, controller.getTaskListSize(), "Ingrese el numero de procesadores: ");
            System.out.println(controller.processScheduling(numProcessors));
            double avg = controller.getAverageTime();
            System.out.println("Tiempo promedio optimizado " + avg + " min.");
        }
    }
}