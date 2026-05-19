package co.edu.udistrital.model.structures;

import co.edu.udistrital.model.entities.Task;
import static co.edu.udistrital.model.sort.BubbleSort.sort;

/**
 * Clase lógica encargada de la planificación y distribución óptima de tareas.
 * Emplea un enfoque Greedy (Algoritmo Voraz) combinando ordenamiento previo
 * y asignaciones en procesadores para minimizar métricas de tiempo.
 *
 * @author Chrz
 */
public class Scheduler {

    /**
     * Planifica las tareas contenidas en una lista distribuyéndolas entre múltiples procesadores.
     * Ordena las tareas de menor a mayor tiempo y asigna secuencialmente cada una al 
     * procesador que posea la menor carga de tiempo acumulada en ese instante.
     *
     * @param list Lista original de tareas a procesar.
     * @param numProcessors Cantidad de procesadores disponibles (tamaño del arreglo resultante).
     * @return Un arreglo de objetos {@link Queue}, donde cada índice representa las tareas agendadas para un procesador.
     */
    public Queue[] schedule(DoubleList list, int numProcessors) {
        Queue[] processors = new Queue[numProcessors];
        for (int i = 0; i < numProcessors; i++) {
            processors[i] = new Queue();
        }
        
        sort(list);
        
        Node current = list.getHead();
        while (current != null) {
            Task task = current.getData();
            Queue bestProcessor = processors[0];
            for (int i = 1; i < numProcessors; i++) {
                if (processors[i].getTotalTime() < bestProcessor.getTotalTime()) {
                    bestProcessor = processors[i];
                }
            }
            bestProcessor.enqueue(task);
            current = current.getNext();
        }
        return processors;
    }

    /**
     * Calcula el tiempo medio de finalización (Mean Completion Time) del conjunto de tareas 
     * en base al esquema de procesadores calculado previamente.
     *
     * @param processors El arreglo de colas con la planificación de los procesadores actuales.
     * @param totalTasks Cantidad total de tareas distribuidas en los sistemas.
     * @return El promedio del tiempo de espera y ejecución global por tarea.
     */
    public double calculateAverageTime(Queue[] processors, int totalTasks) {
        if (totalTasks == 0 || processors == null) {
            return 0.0;
        }

        int totalCompletionSum = 0; 

        for (int i = 0; i < processors.length; i++) {
            Queue currentQueue = processors[i];
            int currentClock = 0; 
            Node currentNode = currentQueue.getHead();

            while (currentNode != null) {
                currentClock += currentNode.getData().getTime();
                totalCompletionSum += currentClock;
                currentNode = currentNode.getNext();
            }
        }
        return (double) totalCompletionSum / totalTasks;
    }
}