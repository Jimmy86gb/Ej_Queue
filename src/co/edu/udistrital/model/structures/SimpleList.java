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

    public SimpleList() {
        head = null;
        tail = null;
        size = 0;
    }

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

    public boolean isIn(String name) {
        Node current = head;
        while (current != null) {
            if (current.getData().getName().equals(name)) { return true; }
            current = current.getNext();
        }
        return false;
    }

    public Node getHead() { return head; }
    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }
}