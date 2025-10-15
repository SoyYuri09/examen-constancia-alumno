package controllers;
import dtos.AlumnoDTO;
import java.util.ArrayList;
import java.util.List;
import models.Alumno;
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
    private Alumno alumnoSeleccionado;
    private boolean busquedaBloqueada;

    public ControlConstancia(List<Alumno> alumnos) {
        this.alumnos = alumnos;
        this.busquedaBloqueada = false;
    }

    public List<AlumnoDTO> cargarAlumnos() {
        List<AlumnoDTO> listaDTO = new ArrayList<>();
        for (Alumno a : alumnos) {
            listaDTO.add(a.toDTO());
        }
        return listaDTO;
    }

    public List<AlumnoDTO> buscarAlumnosPorId(String textoId) {
        return Alumno.buscarAlumnoPorId(alumnos, textoId);
    }

    public void seleccionarAlumno(int id) {
        if (busquedaBloqueada) return;

        for (Alumno a : alumnos) {
            if (a.getId() == id) {
                a.seleccionar(); 
                alumnoSeleccionado = a;
                busquedaBloqueada = true;
                break;
            }
        }
    }

    public String generarConstancia() {
        if (alumnoSeleccionado == null) return "";
        return alumnoSeleccionado.generarConstancia(); 
    }

    public void cancelarConstancia() {
        if (alumnoSeleccionado != null) {
            alumnoSeleccionado.cancelarSeleccion();
            alumnoSeleccionado = null;
            busquedaBloqueada = false;
        }
    }

    public Alumno getAlumnoSeleccionado() { 
        return alumnoSeleccionado; 
    }
    public boolean isBusquedaBloqueada() { 
        return busquedaBloqueada; 
    }
}