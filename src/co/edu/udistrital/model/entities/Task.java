package co.edu.udistrital.model.entities;

/**
 * entidad base que representa una tarea.
 *
 * @author Jimmy86gb
 */
public class Task {
    private final double ti;
    private final String name;

    /**
     * constructor de la tarea.
     *
     * @param time tiempo estimado en minutos
     * @param name nombre de la tarea
     */
    public Task(double time, String name) {
        this.ti = time;
        this.name = name;
    }

    /**
     * obtiene el tiempo de la tarea.
     *
     * @return tiempo en minutos
     */
    public double getTi() { return ti; }

    /**
     * obtiene el nombre de la tarea.
     *
     * @return nombre de la tarea
     */
    public String getName() { return name; }
}