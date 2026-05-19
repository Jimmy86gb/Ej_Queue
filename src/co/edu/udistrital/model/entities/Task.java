package co.edu.udistrital.model.entities;

/**
 * Representa una tarea individual dentro del sistema, definida por su nombre
 * y el tiempo estimado para su ejecución.
 *
 * @author Chrz
 */
public class Task {
    
    private double time;
    private String name;

    /**
     * Construye una nueva tarea con un tiempo y nombre específicos.
     *
     * @param time Tiempo asignado para realizar la tarea (en minutos).
     * @param name Nombre único identificador de la tarea.
     */
    public Task(double time, String name) {
        this.time = time;
        this.name = name;
    }

    /**
     * Obtiene el tiempo de ejecución de la tarea.
     *
     * @return El tiempo en minutos de la tarea.
     */
    public double getTime() {
        return time;
    }

    /**
     * Obtiene el nombre de la tarea.
     *
     * @return El nombre de la tarea.
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica el tiempo de ejecución de la tarea.
     *
     * @param time El nuevo tiempo estimado en minutos.
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * Modifica el nombre de la tarea.
     *
     * @param name El nuevo nombre identificador.
     */
    public void setName(String name) {
        this.name = name;
    }
}