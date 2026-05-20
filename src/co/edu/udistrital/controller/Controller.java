package co.edu.udistrital.controller;

import co.edu.udistrital.model.entities.Task;
import co.edu.udistrital.model.structures.SimpleList;
import co.edu.udistrital.model.structures.Node;
import co.edu.udistrital.model.structures.Queue;
import co.edu.udistrital.model.structures.Scheduler;
import co.edu.udistrital.view.View;

/**
 * controlador principal que centraliza y orquesta el flujo mvc.
 *
 * @author Jimmy86gb
 */
public class Controller {
    private final SimpleList taskList;
    private final Scheduler scheduler;
    private final View view;

    /**
     * inicializa estructuras logicas y la vista.
     */
    public Controller() {
        taskList = new SimpleList();
        scheduler = new Scheduler();
        view = new View();
    }

    /**
     * inicia el bucle iterativo mostrando el menu de operaciones.
     */
    public void run() {
        int option = 0;
        do {
            view.showMsg("\n---- Menu de Asignacion de Tareas ----");
            view.showMsg("1. Anadir Tarea");
            view.showMsg("2. Eliminar Tarea");
            view.showMsg("3. Mostrar Tareas");
            view.showMsg("4. Procesar Tareas");
            view.showMsg("5. Salir");
            
            option = view.readInt("Elija una opcion: ", 1);
            
            switch (option) {
                case 1 -> addTask();
                case 2 -> removeTask();
                case 3 -> showTasks();
                case 4 -> processScheduling();
                case 5 -> view.showMsg("Saliendo del programa...");
                default -> view.showMsg("Opcion no valida");
            }
        } while (option != 5);
    }

    /**
     * gestiona la creacion y validacion de una nueva tarea.
     */
    private void addTask() {
        String name = view.readString("Ingrese el nombre de la tarea: ");
        if (taskList.isIn(name)) {
            view.showMsg("Error, la tarea ya existe");
            return;
        }
        double time = view.readDouble("Ingrese el tiempo de realizacion (minutos): ", 0);
        taskList.add(new Task(time, name));
        view.showMsg("Tarea agregada con exito");
    }

    /**
     * captura el nombre y gestiona la remocion de la lista.
     */
    private void removeTask() {
        if (taskList.isEmpty()) { view.showMsg("No hay tareas"); return; }
        
        showTasks();
        String name = view.readString("Escriba el nombre de la tarea a eliminar: ");
        if (taskList.removeByName(name)) {
            view.showMsg("Tarea eliminada con exito");
        } else {
            view.showMsg("Tarea no encontrada");
        }
    }

    /**
     * recorre la lista completa y delega a la vista su impresion.
     */
    private void showTasks() {
        if (taskList.isEmpty()) { view.showMsg("No hay tareas registradas"); return; }
        
        view.showMsg("\n--- Tareas Registradas ---");
        Node current = taskList.getHead();
        while (current != null) {
            view.showMsg("Nombre: " + current.getData().getName() + " - Tiempo: " + current.getData().getTime() + " min");
            current = current.getNext();
        }
    }

    /**
     * dispara la logica greedy de agendamiento y muestra metricas.
     */
    private void processScheduling() {
        if (taskList.isEmpty()) { view.showMsg("No hay tareas para procesar"); return; }
        
        int numProcessors = view.readInt("Ingrese el numero de procesadores: ", 1);
        Queue[] processors = scheduler.schedule(taskList, numProcessors);
        
        view.showMsg("\n--- Resultados de la Planificacion ---");
        for (int i = 0; i < processors.length; i++) {
            view.showMsgInline("\nProcesador " + (i + 1) + ": ");
            Node current = processors[i].getHead();
            while (current != null) {
                view.showMsgInline("[" + current.getData().getName() + " (" + current.getData().getTime() + " min)] ");
                current = current.getNext();
            }
            view.showMsg("\n -> Tiempo total: " + processors[i].getTotalTime() + " min");
        }
        
        double avg = scheduler.calculateAverageTime(processors, taskList.getSize());
        view.showMsg("\nTiempo promedio optimizado: " + avg + " min.");
    }
}