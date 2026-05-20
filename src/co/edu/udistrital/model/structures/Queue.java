package co.edu.udistrital.model.structures;

import co.edu.udistrital.model.entities.Task;

/**
 * cola simple que acumula tiempo de procesamiento.
 *
 * @author Jimmy86gb
 */
public class Queue {
    private Node head;
    private Node tail;
    private double totalTime;

    /**
     * inicializa la cola vacia y el contador de tiempo en 0.
     */
    public Queue() {
        head = null;
        tail = null;
        totalTime = 0;
    }

    /**
     * encola una tarea al final y suma su duracion al acumulado.
     *
     * @param task tarea a encolar
     */
    public void enqueue(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        totalTime += task.getTime();
    }

    /**
     * obtiene la suma total de los tiempos de la cola.
     *
     * @return sumatoria de tiempo en minutos
     */
    public double getTotalTime() { 
        return totalTime; 
    }

    /**
     * obtiene el nodo que esta al frente de la cola.
     *
     * @return nodo cabeza
     */
    public Node getHead() { 
        return head; 
    }
}