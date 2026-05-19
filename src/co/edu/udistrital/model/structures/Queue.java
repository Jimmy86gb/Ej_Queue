package co.edu.udistrital.model.structures;

import co.edu.udistrital.model.entities.Task;

/**
 * Estructura de datos Lineal de tipo Cola (FIFO - First In, First Out).
 * Utilizada principalmente para agrupar tareas asignadas a procesadores específicos
 * manteniendo la sumatoria del tiempo acumulado de ejecución.
 *
 * @author Chrz
 */
public class Queue {
    private Node head;
    private Node tail;
    private double totalTime;
    
    /**
     * Crea una cola vacía con referencias nulas y tiempo total inicializado en 0.
     */
    public Queue() {
        this.head = null;
        this.tail = null;
        this.totalTime = 0;
    }
    
    /**
     * Remueve y retorna la tarea al frente de la cola (el elemento más antiguo).
     * Resta el valor de tiempo de la tarea del acumulador general de la cola.
     *
     * @return La tarea procesada y retirada, o null si la cola está vacía.
     */
    public Task dequeue() {
        if (isEmpty()) {
            return null; 
        }
        Task taskToReturn = head.getData();
        this.totalTime -= taskToReturn.getTime();
        head = head.getNext();
        if (head == null) {
            tail = null;
        } else {
            head.setPrevious(null);
        }
        return taskToReturn;
    }

    /**
     * Inserta una nueva tarea al final de la cola (el elemento más reciente).
     * Suma la duración de la tarea al acumulador de tiempo total de la estructura.
     *
     * @param task La tarea que se va a encolar.
     */
    public void enqueue(Task task) {
        Node newTask = new Node(task);
        if (head == null) {
            head = newTask;
            tail = newTask;
        } else {
            tail.setNext(newTask);
            newTask.setPrevious(tail);
            tail = newTask;
        }
        totalTime += task.getTime();
    }

    /**
     * Obtiene el acumulado de tiempos de todas las tareas presentes en la cola.
     *
     * @return La sumatoria de tiempos en minutos.
     */
    public double getTotalTime() {
        return this.totalTime;
    }

    /**
     * Obtiene el nodo situado en el frente o cabecera de la cola.
     *
     * @return El nodo cabeza de la cola.
     */
    public Node getHead() {
        return this.head;
    }

    /**
     * Comprueba si la cola no contiene elementos.
     *
     * @return true si la cabeza es null; false si contiene al menos un nodo.
     */
    public boolean isEmpty() {
        return head == null;
    }
}