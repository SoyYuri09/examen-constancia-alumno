package controllers;
import dtos.AlumnoDTO;
import java.util.ArrayList;
import java.util.List;
import models.Alumno;
import models.Materia;
/**
 * ControlConstancia.java
 *
 * Clase de control encargada de manejar la lógica del caso de uso
 * Generar Constancia
 * 
 * @author Yuri Germán García López
 * ID: 00000252583
 */
public class ControlConstancia {
    
    private List<Alumno> alumnos;
    private AlumnoDTO alumnoSeleccionado;

    public ControlConstancia(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

}
