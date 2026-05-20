package co.edu.udistrital.model.entities;

/**
 * entidad base que representa una tarea.
 *
 * @author Jimmy86gb
 */
public class Task {
    private double time;
    private String name;

    /**
     * constructor de la tarea.
     *
     * @param time tiempo estimado en minutos
     * @param name nombre de la tarea
     */
    public Task(double time, String name) {
        this.time = time;
        this.name = name;
    }

    /**
     * obtiene el tiempo de la tarea.
     *
     * @return tiempo en minutos
     */
    public double getTime() { return time; }

    /**
     * obtiene el nombre de la tarea.
     *
     * @return nombre de la tarea
     */
    public String getName() { return name; }
}