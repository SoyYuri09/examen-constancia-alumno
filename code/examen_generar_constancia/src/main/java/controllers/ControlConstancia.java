package controllers;
import dtos.AlumnoDTO;
import java.util.ArrayList;
import java.util.List;
import models.Alumno;
/**
 * ControlConstancia.java
 *
 * Clase de control encargada de manejar el flujo MVC
 * para el caso de uso Generar Constancia
 * 
 * @author Yuri Germán García López
 * ID: 00000252583
 */
public class ControlConstancia {
    
    //Declaración de variables
    private List<Alumno> alumnos;
    private Alumno alumnoSeleccionado;
    private boolean busquedaBloqueada;

    /**
     * Constructor que instancia la lista de alumnos inscritos
     * 
     * @param alumnos Lista de alumnos
     */
    public ControlConstancia(List<Alumno> alumnos) {
        this.alumnos = alumnos;
        this.busquedaBloqueada = false;
    }

    /**
     * Método que carga todos los alumnos inscritos 
     * en forma de DTO
     * 
     * @return Lista de alumnos DTO
     */
    public List<AlumnoDTO> cargarAlumnos() {
        List<AlumnoDTO> listaDTO = new ArrayList<>();
        for (Alumno a : alumnos) {
            listaDTO.add(a.toDTO());
        }
        return listaDTO;
    }

    /**
     * Método que permite buscar alumnos por medio
     * de coincidencias oh match en su Id
     * 
     * @param textoId String que contiene el id del alumno a buscar
     * @return Lista de alumnos DTO que coincidan con el id ingresado
     */
    public List<AlumnoDTO> buscarAlumnosPorId(String textoId) {
        return Alumno.buscarAlumnoPorId(alumnos, textoId);
    }

    /**
     * Método para seleccionar un alumno mostrado en la tabla
     * por medio de su id
     * 
     * @param id Id del alumno seleccionado
     */
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

    /**
     * Método para generar la constancia de inscripción
     * del alumno seleccionado
     * 
     * @return Texto de constancia de inscripción
     */
    public String generarConstancia() {
        if (alumnoSeleccionado == null) return "";
        return alumnoSeleccionado.generarConstancia(); 
    }

    /**
     * Método para cancelar la constancia 
     * y permitir nuevamente la búsqueda de alumnos
     */
    public void cancelarConstancia() {
        if (alumnoSeleccionado != null) {
            alumnoSeleccionado.cancelarSeleccion();
            alumnoSeleccionado = null;
            busquedaBloqueada = false;
        }
    }
    
    /**
     * Método que permite salir de la constancia
     * generada y permitir nuevamente la búsqueda de alumnos
     */
    public void regresarBusqueda() {
        if (alumnoSeleccionado != null) {
            alumnoSeleccionado.regresarBusqueda();
            alumnoSeleccionado = null;
            busquedaBloqueada = false;
        }
    }

    /**
     * Método que devuelve el alumno seleccionado
     * 
     * @return Alumno seleccionado
     */
    public Alumno getAlumnoSeleccionado() { 
        return alumnoSeleccionado; 
    }
    
    /**
     * Método que indica si la búsqueda de alumnos se encuentra 
     * bloqueada
     * 
     * @return 
     */
    public boolean isBusquedaBloqueada() { 
        return busquedaBloqueada; 
    }
}