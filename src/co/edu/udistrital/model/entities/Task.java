package co.edu.udistrital.model.entities;

/**
 * entidad base que representa una tarea.
 *
 * @author Jimmy86gb
 */
public class Task {
    private double time;
    private String name;

    public Task(double time, String name) {
        this.time = time;
        this.name = name;
    }

    public double getTime() { return time; }
    public String getName() { return name; }
}