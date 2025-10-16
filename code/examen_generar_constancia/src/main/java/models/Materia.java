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
    
    //Declaración de variables
    private String nombre;
    private int id;

    /**
     * Constructor que incializa todos los atributos de la clase
     * 
     * @param nombre Nombre de la materia
     * @param id Id de la materia
     */
    public Materia(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
    
}