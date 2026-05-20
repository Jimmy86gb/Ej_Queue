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

    public Node(Task data) {
        this.data = data;
        this.next = null;
    }

    public Task getData() { return data; }
    public void setData(Task data) { this.data = data; }
    public Node getNext() { return next; }
    public void setNext(Node next) { this.next = next; }
}