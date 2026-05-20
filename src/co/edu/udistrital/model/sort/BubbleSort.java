package co.edu.udistrital.model.sort;

import co.edu.udistrital.model.entities.Task;
import co.edu.udistrital.model.structures.Node;
import co.edu.udistrital.model.structures.SimpleList;

/**
 * ordenamiento burbuja in-situ para lista simplemente enlazada.
 *
 * @author Jimmy86gb
 */
public class BubbleSort {
    
    public static void sort(SimpleList list) {
        if (list.getHead() == null) { return; }
        
        boolean swapped;
        do {
            swapped = false;
            Node current = list.getHead();
            while (current.getNext() != null) {
                if (current.getData().getTime() > current.getNext().getData().getTime()) {
                    Task temp = current.getData();
                    current.setData(current.getNext().getData());
                    current.getNext().setData(temp);
                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
    }
}