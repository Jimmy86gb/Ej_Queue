package co.edu.udistrital.model.sort;

import co.edu.udistrital.model.entities.Task;
import co.edu.udistrital.model.structures.*;

/**
 * Componente que provee el algoritmo de ordenamiento de la burbuja (Bubble Sort).
 * Se encarga de ordenar los elementos de una {@link DoubleList} basándose en el 
 * tiempo de ejecución de las tareas de forma ascendente.
 *
 * @author Chrz
 */
public class BubbleSort {

    /**
     * Ordena de manera in-situ (mutando la estructura original) una lista doblemente enlazada.
     * Intercambia los datos internos de los nodos según la duración de sus tareas.
     *
     * @param list La lista de tareas que se desea ordenar ascendentemente.
     */
    public static void sort(DoubleList list) {

        if (list.getHead() == null) {
            return;
        }

        boolean swapped;
        Node last = null;

        do {
            swapped = false;
            Node current = list.getHead();

            while (current.getNext() != last) {

                if (current.getData().getTime() > current.getNext().getData().getTime()) {
                   
                    Task temp = current.getData();

                    current.setData(current.getNext().getData());
                    current.getNext().setData(temp);

                    swapped = true;
                }

                current = current.getNext();
            }

            last = current;

        } while (swapped);
    }
}