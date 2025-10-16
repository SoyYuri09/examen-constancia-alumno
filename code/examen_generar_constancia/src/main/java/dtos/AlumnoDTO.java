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
    
    //Declaración de variables
    public String nombre;
    private int id;
    private String programa;
    private String cicloEscolar;
    private int semestreInscrito;
    private List<String> materias;

    /**
     * Constructor vacío
     */
    public AlumnoDTO() {
    }

    /**
     * Constructor que incializa todos los atributos de la calse
     * 
     * @param nombre Nombre completo del alumno.
     * @param id Id del alumno.
     * @param programa Programa educativo del alumno.
     * @param cicloEscolar Ciclo escolar que cursa el alumno.
     * @param semestreInscrito Semestre actual que cursa el alumno.
     * @param materias Materias a las que se encuentra cursando el alumno
     */
    public AlumnoDTO(String nombre, int id, String programa, String cicloEscolar, int semestreInscrito, List<String> materias) {
        this.nombre = nombre;
        this.id = id;
        this.programa = programa;
        this.cicloEscolar = cicloEscolar;
        this.semestreInscrito = semestreInscrito;
        this.materias = materias;
    }

    /**
     * @return Obtiene Nombre completo del alumno
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Establece Nombre completo del alumno
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Obtiene el Id del alumno
     */
    public int getId() {
        return id;
    }

    /**
     * @param id Establece el Id del alumno
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Obtiene el programa educativo del alumno
     */
    public String getPrograma() {
        return programa;
    }

    /**
     * @param programa Establece el programa educativo del alumno
     */
    public void setPrograma(String programa) {
        this.programa = programa;
    }

    /**
     * @return Obtiene el ciclo escolar del alumno
     */
    public String getCicloEscolar() {
        return cicloEscolar;
    }
    
    /**
     * @param cicloEscolar Establece el ciclo escolar del alumno
     */
    public void setCicloEscolar(String cicloEscolar) {
        this.cicloEscolar = cicloEscolar;
    }

    /**
     * @return Obtiene el semestre que cursa el alumno 
     */
    public int getSemestreInscrito() {
        return semestreInscrito;
    }

    /**
     * @param semestreInscrito Establece el semestre que cursa el alumno
     */
    public void setSemestreInscrito(int semestreInscrito) {
        this.semestreInscrito = semestreInscrito;
    }

    /**
     * @return Obtiene la Lista de las materias que cursa el alumno
     */
    public List<String> getMaterias() {
        return materias;
    }

    /**
     * @param materias Establece la lista de materias que cursa el alumno
     */
    public void setMaterias(List<String> materias) {
        this.materias = materias;
    }

    /**
     * Método toString
     * @return Cadena con todos los valores del DTO formateados
     */
    @Override
    public String toString() {
        return "AlumnoDTO{" + "nombre=" + nombre + ", id=" + id + ", programa=" + programa + ", cicloEscolar=" + cicloEscolar + ", semestreInscrito=" + semestreInscrito + ", materias=" + materias + '}';
    }
    
    /**
     * Método que convierte un objeto Alumno del modelo en 
     * su versión DTO.
     * 
     * @param alumno obtejo Alumno
     * @return Objeto AlumnoDTO con los datos del alumno
     */
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

    /**
     * Método que permite recontruir el modelo a partir
     * de una DTO en este caso Alumno
     * 
     * @return Objeto Alumno con los datos contenidos en la DTO
     */
    public Alumno toModel() {
        Alumno alumno = new Alumno(nombre, id, programa, cicloEscolar, semestreInscrito);
        return alumno;
    }
}