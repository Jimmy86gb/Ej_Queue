package co.edu.udistrital.model.structures;

import co.edu.udistrital.model.entities.Task;

/**
 * Representa un nodo genérico de una estructura de datos doblemente enlazada,
 * encargado de almacenar un objeto de tipo {@link Task} y mantener las referencias
 * al nodo anterior y siguiente.
 *
 * @author Chrz
 */
public class Node {

    private Task data;
    private Node next;
    private Node previous;

    /**
     * Crea un nodo de manera aislada con la información proporcionada.
     * Los enlaces anterior y siguiente se inicializan en null.
     *
     * @param data La información de la tarea a almacenar.
     */
    public Node(Task data) {
        this.data = data;
    }

    /**
     * Crea un nodo vinculándolo explícitamente con sus vecinos.
     *
     * @param data La información de la tarea a almacenar.
     * @param next El nodo que estará conectado inmediatamente después.
     * @param previous El nodo que estará conectado inmediatamente antes.
     */
    public Node(Task data, Node next, Node previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    /**
     * Devuelve la tarea almacenada dentro del nodo.
     *
     * @return La tarea actual del nodo.
     */
    public Task getData() {
        return data;
    }

    /**
     * Reemplaza la tarea interna del nodo por una nueva.
     *
     * @param data La nueva tarea a asignar.
     */
    public void setData(Task data) {
        this.data = data;
    }

    /**
     * Obtiene el nodo consecutivamente posterior en el enlace.
     *
     * @return El nodo siguiente.
     */
    public Node getNext() {
        return next;
    }
    
    /**
     * Obtiene el nodo consecutivamente anterior en el enlace.
     *
     * @return El nodo previo.
     */
    public Node getPrevious() {
        return previous;
    }
    
    /**
     * Atajo para obtener directamente la información del nodo anterior.
     *
     * @return La tarea contenida en el nodo anterior.
     */
    public Task getPreviousData() {
        Node p = getPrevious();
        return p.getData();
    }

    /**
     * Atajo para obtener directamente la información del nodo siguiente.
     *
     * @return La tarea contenida en el nodo siguiente.
     */
    public Task getNextData() {
        Node n = getNext();
        return n.getData();
    }
    
    /**
     * Establece el nodo anterior a este.
     *
     * @param previous El nodo que antecederá al actual.
     */
    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    /**
     * Establece el nodo siguiente a este.
     *
     * @param next El nodo que sucederá al actual.
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Atajo para actualizar de forma directa los datos del nodo siguiente.
     *
     * @param data La tarea que se asignará al nodo siguiente.
     */
    public void setNextData(Task data) {
        Node n = getNext();
        n.setData(data);
    }
    
    /**
     * Atajo para actualizar de forma directa los datos del nodo anterior.
     *
     * @param data La tarea que se asignará al nodo anterior.
     */
    public void setPreviousData(Task data) {
        Node p = getPrevious();
        p.setData(data);
    }

    /**
     * Convierte el nodo a formato de texto para facilitar su visualización.
     *
     * @return Representación textual de la tarea contenida en el nodo.
     */
    @Override
    public String toString() {
        return data.toString();
    }
}