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

    public Queue() {
        head = null;
        tail = null;
        totalTime = 0;
    }

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

    public double getTotalTime() { return totalTime; }
    public Node getHead() { return head; }
}