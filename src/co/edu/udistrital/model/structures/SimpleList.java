package co.edu.udistrital.model.structures;

import co.edu.udistrital.model.entities.Task;

/**
 * estructura de lista simplemente enlazada.
 *
 * @author Jimmy86gb
 */
public class SimpleList {
    private Node head;
    private Node tail;
    private int size;

    /**
     * inicializa la lista vacia.
     */
    public SimpleList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * agrega una nueva tarea al final de la lista.
     *
     * @param data tarea a insertar
     */
    public void add(Task data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    /**
     * elimina una tarea buscando por su nombre en la lista simple.
     *
     * @param name nombre de la tarea a eliminar
     * @return true si se elimino, false si no se encontro
     */
    public boolean removeByName(String name) {
        if (head == null) { return false; }
        
        if (head.getData().getName().equals(name)) {
            head = head.getNext();
            if (head == null) { tail = null; }
            size--;
            return true;
        }
        
        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().getName().equals(name)) {
                current.setNext(current.getNext().getNext());
                if (current.getNext() == null) { tail = current; }
                size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * verifica si una tarea ya existe en la lista.
     *
     * @param name nombre a buscar
     * @return true si existe, false en caso contrario
     */
    public boolean isIn(String name) {
        Node current = head;
        while (current != null) {
            if (current.getData().getName().equals(name)) { return true; }
            current = current.getNext();
        }
        return false;
    }

    /**
     * obtiene el primer nodo de la lista.
     *
     * @return nodo cabeza
     */
    public Node getHead() { return head; }

    /**
     * obtiene la cantidad de elementos de la lista.
     *
     * @return tamano
     */
    public int getSize() { return size; }

    /**
     * verifica si la lista esta vacia.
     *
     * @return true si esta vacia, false si tiene elementos
     */
    public boolean isEmpty() { 
        return size == 0; 
    }
}