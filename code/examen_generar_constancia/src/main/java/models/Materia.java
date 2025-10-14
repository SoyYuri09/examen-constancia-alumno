package models;
/**
 * Materia.java
 *
 * Clase entidad que representa una materia que
 * un alumno inscrito puede cursar.
 * 
 * @author Yuri Germán García López
 * ID: 00000252583
 *
 */
public class Materia {
    
    private String nombre;
    private int id;

    public Materia(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
    
}
