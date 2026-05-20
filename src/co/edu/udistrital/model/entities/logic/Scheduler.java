package co.edu.udistrital.model.entities.logic;

import co.edu.udistrital.model.structures.Node;
import co.edu.udistrital.model.structures.Queue;
import co.edu.udistrital.model.structures.SimpleList;
import static co.edu.udistrital.model.sort.BubbleSort.sort;

/**
 * planificador greedy de tareas sobre procesadores.
 *
 * @author Jimmy86gb
 */
public class Scheduler {
    
    /**
     * distribuye las tareas de la lista en los procesadores optimizando tiempos.
     *
     * @param list lista de tareas a procesar
     * @param numProcessors numero de procesadores disponibles
     * @return arreglo de colas con las asignaciones correspondientes
     */
    public Queue[] schedule(SimpleList list, int numProcessors) {
        Queue[] processors = new Queue[numProcessors];
        for (int i = 0; i < numProcessors; i++) { 
            processors[i] = new Queue(); 
        }
        
        sort(list);
        
        Node current = list.getHead();
        while (current != null) {
            Queue best = processors[0];
            for (int i = 1; i < numProcessors; i++) {
                if (processors[i].getTotalTime() < best.getTotalTime()) { 
                    best = processors[i]; 
                }
            }
            best.enqueue(current.getData());
            current = current.getNext();
        }
        return processors;
    }

    /**
     * calcula el tiempo medio de finalizacion de todas las tareas.
     *
     * @param processors arreglo de procesadores evaluados
     * @param totalTasks total de tareas en el sistema
     * @return tiempo promedio en minutos
     */
    public double calculateAverageTime(Queue[] processors, int totalTasks) {
        if (totalTasks == 0 || processors == null) { return 0.0; }
        
        double totalSum = 0;
        for (Queue q : processors) {
            double clock = 0;
            Node current = q.getHead();
            while (current != null) {
                clock += current.getData().getTi();
                totalSum += clock;
                current = current.getNext();
            }
        }
        return totalSum / totalTasks;
    }
}