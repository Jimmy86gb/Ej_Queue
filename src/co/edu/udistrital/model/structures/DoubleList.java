package co.edu.udistrital.model.structures;

import co.edu.udistrital.model.entities.Task;

/**
 * Estructura de datos que representa una Lista Doblemente Enlazada.
 * Permite el almacenamiento dinámico de tareas con acceso bidireccional.
 *
 * @author Chrz
 */
public class DoubleList {

    private Node head;
    private Node tail;
    private int size;

    /**
     * Inicializa una lista doblemente enlazada vacía sin elementos internos.
     */
    public DoubleList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Agrega una nueva tarea al final de la lista.
     *
     * @param data La tarea que se desea insertar.
     */
    public void add(Task data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }
    
    /**
     * Busca y elimina una tarea de la lista usando su nombre como criterio.
     * Reestructura de forma segura los enlaces de los nodos adyacentes.
     *
     * @param name Nombre de la tarea que se desea remover.
     * @return true si la tarea fue encontrada y eliminada con éxito; false en caso contrario.
     */
    public boolean removeByName(String name) {
        if (head == null) {
            return false;
        }
        Node current = head;
        Node next = current.getNext();
        Node previous = current.getPrevious();
        do {
            if (current.getData().getName().equals(name)) {
                if (size == 1) {
                    head = null;
                    tail = null;
                } else {
                    if (previous != null) previous.setNext(current.getNext());
                    if (next != null) next.setPrevious(current.getPrevious());
                    if (current == head) {
                        head = current.getNext();
                    }
                    if (current == tail) {
                        tail = current.getPrevious();
                    }
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
            if (next != null) next = next.getNext();
        } while (current != null);
        return false;
    }

    /**
     * Devuelve el primer nodo de la lista (cabeza).
     *
     * @return El nodo cabeza.
     */
    public Node getHead() {
        return head;
    }

    /**
     * Devuelve el nodo que se encuentra inmediatamente después de la cabeza.
     * * @return El nodo consecutivamente posterior a la cabeza.
     */
    public Node getNextNodeToHead() {
        Node h = getHead();
        return h.getNext();
    }

    /**
     * Asigna un nodo como la nueva cabeza de la lista.
     *
     * @param head El nuevo nodo inicial.
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * Devuelve el último nodo de la lista (cola).
     *
     * @return El nodo cola.
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Asigna un nodo como la nueva cola de la lista.
     *
     * @param tail El nuevo nodo final.
     */
    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**
     * Devuelve la cantidad total de elementos que contiene la lista.
     *
     * @return El tamaño actual de la lista.
     */
    public int getSize() {
        return size;
    }

    /**
     * Modifica el contador de tamaño de la lista de forma directa.
     *
     * @param size El nuevo tamaño.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Evalúa si la lista carece de elementos.
     *
     * @return verdadero (true) si el tamaño es 0, falso (false) si tiene elementos.
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * Verifica si una tarea con un nombre específico ya existe dentro de la lista.
     *
     * @param name Nombre de la tarea que se busca validar.
     * @return true si la tarea se encuentra en la lista; false en caso contrario.
     */
    public boolean isIn(String name) {
        if (getSize() == 0) {
            return false;
        }
        Node current = head;
        while (current != null) {
            if (current.getData().getName().equals(name)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Busca y retorna el nodo ubicado en un índice posicional específico.
     *
     * @param index La posición numérica requerida (indexación en base 0).
     * @return El nodo en la posición indicada, o null si el índice está fuera de rango.
     */
    public Node getNodeAt(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.getNext();
            count++;
        }
        return current;
    }
}