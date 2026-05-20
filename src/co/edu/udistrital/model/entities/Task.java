package co.edu.udistrital.model.entities;

/**
 * entidad base que representa una tarea.
 *
 * @author Jimmy86gb
 */
public class Task {
    private double time;
    private String name;
    private boolean isDone; // nuevo atributo de estado

    /**
     * constructor de la tarea.
     *
     * @param time tiempo estimado en minutos
     * @param name nombre de la tarea
     */
    public Task(double time, String name) {
        this.time = time;
        this.name = name;
        this.isDone = false; // por defecto inicia sin hacer
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

    /**
     * verifica si la tarea ya fue ejecutada.
     *
     * @return true si esta hecha, false si no
     */
    public boolean isDone() { return isDone; }

    /**
     * cambia el estado de realizacion de la tarea.
     *
     * @param done nuevo estado
     */
    public void setDone(boolean done) { this.isDone = done; }
}