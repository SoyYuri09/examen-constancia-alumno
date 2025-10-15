package dtos;
import java.util.ArrayList;
import java.util.List;
import models.Alumno;
import models.Materia;
/**
 * AlumnoDTO.java
 * 
 * Data Transfer Object (DTO) para la entidad Alumno.
 * 
 * Transporta información del alumno entre
 * las capas del sistema.
 * 
 * @author Yuri Germán García López
 * ID: 00000252583
 */
public class AlumnoDTO {
    
    public String nombre;
    private int id;
    private String programa;
    private String cicloEscolar;
    private int semestreInscrito;
    private List<String> materias;

    public AlumnoDTO() {
    }

    public AlumnoDTO(String nombre, int id, String programa, String cicloEscolar, int semestreInscrito, List<String> materias) {
        this.nombre = nombre;
        this.id = id;
        this.programa = programa;
        this.cicloEscolar = cicloEscolar;
        this.semestreInscrito = semestreInscrito;
        this.materias = materias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getCicloEscolar() {
        return cicloEscolar;
    }

    public void setCicloEscolar(String cicloEscolar) {
        this.cicloEscolar = cicloEscolar;
    }

    public int getSemestreInscrito() {
        return semestreInscrito;
    }

    public void setSemestreInscrito(int semestreInscrito) {
        this.semestreInscrito = semestreInscrito;
    }

    public List<String> getMaterias() {
        return materias;
    }

    public void setMaterias(List<String> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "AlumnoDTO{" + "nombre=" + nombre + ", id=" + id + ", programa=" + programa + ", cicloEscolar=" + cicloEscolar + ", semestreInscrito=" + semestreInscrito + ", materias=" + materias + '}';
    }
    
    public static AlumnoDTO fromModel(Alumno alumno) {
        List<String> nombresMaterias = new ArrayList<>();
        for (Materia m : alumno.getMaterias()) {
            nombresMaterias.add(m.getNombre());
        }

        return new AlumnoDTO(
                alumno.getNombre(),
                alumno.getId(),
                alumno.getPrograma(),
                alumno.getCicloEscolar(),
                alumno.getSemestreInscrito(),
                nombresMaterias
        );
    }

    public Alumno toModel() {
        Alumno alumno = new Alumno(nombre, id, programa, cicloEscolar, semestreInscrito);
        return alumno;
    }
}