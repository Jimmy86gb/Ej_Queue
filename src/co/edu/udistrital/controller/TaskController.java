package co.edu.udistrital.controller;

import co.edu.udistrital.model.entities.Task;
import co.edu.udistrital.model.structures.DoubleList;
import co.edu.udistrital.model.structures.Node;
import co.edu.udistrital.model.structures.Queue;
import co.edu.udistrital.model.structures.Scheduler;

/**
 * Componente Controlador central del patrón de diseño MVC. Orienta las comunicaciones
 * entre la interfaz de usuario orientada a consola y la lógica de estructuras internas del modelo.
 *
 * @author Chrz
 */
public class TaskController {
    private DoubleList taskList;
    private Scheduler scheduler;
    private Queue[] lastCalculatedProcessors;

    /**
     * Construye e inicializa el controlador de tareas levantando una lista vacía
     * y el motor de planificación.
     */
    public TaskController() {
        this.taskList = new DoubleList();
        this.scheduler = new Scheduler();
        this.lastCalculatedProcessors = null;
    }

    /**
     * Crea una nueva tarea y la añade al sistema validando que el nombre no esté duplicado.
     *
     * @param time Minutos asignados de la tarea.
     * @param name Nombre identificativo del proceso.
     * @return true si la inserción es exitosa, false si se detectó una tarea repetida.
     */
    public boolean createTask(double time, String name) {
        Task newTask = new Task(time, name);
        if (!isRepeated(newTask)) {
            taskList.add(newTask);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Valida internamente si una tarea posee el mismo nombre que otra ya guardada.
     *
     * @param task Objeto tarea que se desea comprobar.
     * @return true si el nombre ya figura registrado; false en caso contrario.
     */
    public boolean isRepeated(Task task) {
        return taskList.isIn(task.getName());
    }

    /**
     * Remueve una tarea del almacenamiento dinámico a través de su nombre clave.
     *
     * @param name Nombre de la tarea a suprimir.
     * @return true si el elemento existía y fue removido; false si no se halló.
     */
    public boolean deleteTask(String name) {
       return taskList.removeByName(name);
    }
    
    /**
     * Genera una cadena formateada que resume visualmente todas las tareas actualmente registradas.
     *
     * @return Texto estructurado listo para desplegar por consola.
     */
    public String getTasksAsText() {
        if (taskList.isEmpty()) {
            return "No hay tareas registradas";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Tareas Registradas ---\n");
        
        Node current = taskList.getHead(); 
        while (current != null) {
            sb.append("Nombre: ").append(current.getData().getName())
              .append(" Tiempo: ").append(current.getData().getTime()).append(" min\n");
            current = current.getNext();
        }
        return sb.toString();
    }
    
    /**
     * Dispara el algoritmo de planificación por medio del programador (Scheduler)
     * para el total de procesadores indicados. Construye la respuesta visual en formato de texto.
     *
     * @param numProcessors El número de hilos o procesadores paralelos a simular.
     * @return Cadena que representa el mapeo y la distribución final de tareas por procesador.
     */
    public String processScheduling(int numProcessors) {
        this.lastCalculatedProcessors = scheduler.schedule(taskList, numProcessors);
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Resultados ---\n");
        for (int i = 0; i < lastCalculatedProcessors.length; i++) {
            sb.append("\nCola del procesador ").append(i + 1).append(":");
            Node current = lastCalculatedProcessors[i].getHead();
            while (current != null) {
                sb.append(" [Nombre: ").append(current.getData().getName())
                  .append(" Tiempo: ").append(current.getData().getTime()).append(" min] ");
                current = current.getNext();
            }
            sb.append("Tiempo total: ").append(lastCalculatedProcessors[i].getTotalTime()).append("min \n");
        }
        return sb.toString();
    }

    /**
     * Calcula el promedio de tiempo optimizado derivado del último procesamiento realizado.
     *
     * @return Valor double con el tiempo promedio general de completado.
     */
    public double getAverageTime() {
        int totalTasks = taskList.getSize();
        return scheduler.calculateAverageTime(this.lastCalculatedProcessors, totalTasks);
    }
    
    /**
     * Valida de manera externa si la lista interna de tareas está libre de datos.
     *
     * @return true en caso de estar vacía, false si contiene información.
     */
    public boolean taskListIsEmpty() {
        return taskList.isEmpty();
    }

    /**
     * Informa el volumen total de tareas activas.
     *
     * @return Entero representativo del tamaño de la lista de tareas.
     */
    public int getTaskListSize() {
        return taskList.getSize();
    }
}