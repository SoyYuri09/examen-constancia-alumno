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
    private Alumno alumnoSeleccionado;
    private AlumnoDTO alumnoSeleccionadoDTO;

    private boolean busquedaBloqueada;

    public ControlConstancia(List<Alumno> alumnos) {
        this.alumnos = alumnos;
        this.busquedaBloqueada = false;
    }

    public List<AlumnoDTO> cargarAlumnos() {
        List<AlumnoDTO> listaDTO = new ArrayList<>();
        for (Alumno a : alumnos) {
            AlumnoDTO dto = new AlumnoDTO();
            dto.setId(a.getId());
            dto.setNombre(a.getNombre());
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    public void seleccionarAlumno(int id) {
        if (busquedaBloqueada) return;

        for (Alumno a : alumnos) {
            if (a.getId() == id) {
                alumnoSeleccionado = a;
                alumnoSeleccionadoDTO = AlumnoDTO.fromModel(a);
                busquedaBloqueada = true;
                break;
            }
        }
    }

    public AlumnoDTO mostrarDatosAlumno(Alumno alumno) {
        if (alumno == null) return null;

        AlumnoDTO dto = new AlumnoDTO();
        dto.setId(alumno.getId());
        dto.setNombre(alumno.getNombre());
        dto.setPrograma(alumno.getPrograma());
        dto.setCicloEscolar(alumno.getCicloEscolar());
        dto.setSemestreInscrito(alumno.getSemestreInscrito());
        return dto;
    }

    public String generarConstancia(Alumno alumno) {
        if (alumno == null) return "";

        StringBuilder constancia = new StringBuilder();
        constancia.append("CONSTANCIA ACADÉMICA\n\n");
        constancia.append("Por este medio se hace constar que el alumno ")
                  .append(alumno.getNombre())
                  .append(", con ID ")
                  .append(alumno.getId())
                  .append(", pertenece al programa educativo ")
                  .append(alumno.getPrograma())
                  .append(", en el ciclo escolar ")
                  .append(alumno.getCicloEscolar())
                  .append(", cursando actualmente el semestre ")
                  .append(alumno.getSemestreInscrito())
                  .append(".\n\n");

        constancia.append("Actualmente cursa ")
                  .append(alumno.getNumMaterias())
                  .append(" materias.\n\n");

        constancia.append("Atentamente,\n");
        constancia.append("La Coordinación Académica.");

        alumno.notificarObservadores(
            "Constancia generada para " + alumno.getNombre()
        );

        return constancia.toString();
    }

    public void cancelarConstancia() {
        alumnoSeleccionado = null;
        alumnoSeleccionadoDTO = null;
        busquedaBloqueada = false;
    }

    public boolean isBusquedaBloqueada() {
        return busquedaBloqueada;
    }

    public Alumno getAlumnoSeleccionado() {
        return alumnoSeleccionado;
    }

}