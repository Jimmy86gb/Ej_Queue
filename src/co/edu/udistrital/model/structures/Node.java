package co.edu.udistrital.model.structures;

import co.edu.udistrital.model.entities.Task;

/**
 * nodo de enlace simple para ahorrar memoria.
 *
 * @author Jimmy86gb
 */
public class Node {
    private Task data;
    private Node next;

    /**
     * constructor del nodo.
     *
     * @param data informacion de la tarea a almacenar
     */
    public Node(Task data) {
        this.data = data;
        this.next = null;
    }

    /**
     * obtiene la tarea almacenada.
     *
     * @return tarea actual
     */
    public Task getData() { return data; }

    /**
     * actualiza la tarea del nodo.
     *
     * @param data nueva tarea
     */
    public void setData(Task data) { this.data = data; }

    /**
     * obtiene el nodo siguiente.
     *
     * @return nodo siguiente
     */
    public Node getNext() { return next; }

    /**
     * establece el nodo siguiente.
     *
     * @param next proximo nodo
     */
    public void setNext(Node next) { this.next = next; }
}